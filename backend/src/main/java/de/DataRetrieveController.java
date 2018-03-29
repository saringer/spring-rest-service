package de;

import de.data_access_objects.coursing.Rating;
import de.data_access_objects.coursing.TotalParticipation;
import de.data_models.*;
import de.data_transfer_objects.CoursingResult;

import de.data_transfer_objects.RaceDTO;
import de.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/get")
public class DataRetrieveController {

    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private BreederRepository breederRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private JudgeRepository judgeRepository;
    //Autowired
    //private TournamentDogRepository tournamentDogRepository;
    @Autowired
    EntityManager em;


    private Long getAverageOfBestRatings(Long dog_id) {
        Integer double_weighted_couter = 0;
        Long sum = Integer.toUnsignedLong(0);
        List<Rating> ratings = (List<Rating>) em.createNativeQuery("SELECT coursing.coursing_rating, tournament.double_weighted FROM coursing JOIN tournament ON tournament.tournament_id = coursing.tournament_id WHERE coursing.dog_id = " + dog_id + "  ORDER BY coursing.coursing_rating DESC LIMIT 5", "ratings").getResultList();
        for (int i = 0; i < ratings.size(); i++) {
            if (ratings.get(i).getCoursing_rating() != null) {
                if (ratings.get(i).isDouble_weighted()) {
                    double_weighted_couter++;
                    sum = sum + (ratings.get(i).getCoursing_rating() * 2);

                } else {
                    sum = sum + ratings.get(i).getCoursing_rating();

                }
            }


        }
        return sum / (ratings.size() + double_weighted_couter);
    }


    @CrossOrigin
    @RequestMapping(value = "/dog/{dog_id}", method = RequestMethod.GET)
    public Dog getDog(@PathVariable long dog_id) {
        System.out.println(dog_id);
        return dogRepository.findById(dog_id);
    }

    @CrossOrigin
    @RequestMapping(value = "/dogs", method = RequestMethod.GET)
    public List<Dog> getDogs() {
        System.out.println("all dogs");
        // Sort results regarding names
        List<Dog> allDogs = dogRepository.findAll();
        if (allDogs.size() > 0) {
            Collections.sort(allDogs, new Comparator<Dog>() {
                @Override
                public int compare(final Dog object1, final Dog object2) {
                    return object1.getName().compareTo(object2.getName());
                }
            });

        }

        return allDogs;

    }

    @CrossOrigin
    @RequestMapping(value = "/tournamentdogs/{id}", method = RequestMethod.GET)
    public List<Coursing> getTournamentDog(@PathVariable long id) {
        System.out.println("all tournamentdogs");
        if (tournamentRepository.findById(id) != null) {
            List<Coursing> coursings = tournamentRepository.findById(id).getCoursings();
            for (int i=0;i<coursings.size();i++) {
                coursings.get(i).setDogname(formatDogAndKennel(coursings.get(i).getDog().getId()));
            }
            return coursings;
        } else return null;
        //return tournamentRepository.findOne(id).getCoursings();
    }

    @CrossOrigin
    @RequestMapping(value = "/races/{id}", method = RequestMethod.GET)
    public List<RaceDTO> getRace(@PathVariable long id) {
        System.out.println("all races");
        if (tournamentRepository.findById(id) != null) {
            List<RaceDTO> dtoList = new ArrayList<>();

            List<Race> races = tournamentRepository.findById(id).getRaces();
            for (int i = 0; i < races.size(); i++) {
                RaceDTO dto = new RaceDTO();
                //dto.setDogname(dogRepository.getOne(races.get(i).getDog().getId()).getName());
                dto.setDogname(formatDogAndKennel(races.get(i).getDog().getId()));
                dto.setNotfinished(races.get(i).isNotfinished());
                dto.setWithdrawn(races.get(i).isWithdrawn());
                dto.setRacePlacement(races.get(i).getRacePlacement());
                dto.setRaceTime(races.get(i).getRaceTime());
                dto.setTournamentid(id);
                dto.setTournament(races.get(i).getTournament());
                dto.setDog(races.get(i).getDog());
                dto.setDistance(races.get(i).getDistance());
                dtoList.add(dto);
            }
            return dtoList;
        } else return null;
        //return tournamentRepository.findOne(id).getCoursings();
    }

    @CrossOrigin
    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    public List<Owner> getOwners() {
        System.out.println("all owners");
        List<Owner> allowner = ownerRepository.findAll();
        if (allowner.size() > 0) {
            Collections.sort(allowner, new Comparator<Owner>() {
                @Override
                public int compare(final Owner object1, final Owner object2) {
                    return object1.getLastname().compareTo(object2.getLastname());
                }
            });

        }
        return allowner;
    }

    @CrossOrigin
    @RequestMapping(value = "/tournament/{tournament_id}", method = RequestMethod.GET)
    public Tournament getTournament(@PathVariable long tournament_id) {
        System.out.println(tournament_id);
        return tournamentRepository.findById(tournament_id);
    }

    @CrossOrigin
    @RequestMapping(value = "/tournaments", method = RequestMethod.GET)
    public List<Tournament> getTournaments() {
        System.out.println("all tournaments");
        List<Tournament> alltournaments = tournamentRepository.findAll();
        if (alltournaments.size() > 0) {
            Collections.sort(alltournaments, new Comparator<Tournament>() {
                @Override
                public int compare(final Tournament object1, final Tournament object2) {
                    return object1.getTitle().compareTo(object2.getTitle());
                }
            });

        }
        return alltournaments;
    }

    @CrossOrigin
    @RequestMapping(value = "/breeders", method = RequestMethod.GET)
    public List<Breeder> getBreeders() {
        System.out.println("all Breeder");
        List<Breeder> allbreeders = breederRepository.findAll();
        if (allbreeders.size() > 0) {
            Collections.sort(allbreeders, new Comparator<Breeder>() {
                @Override
                public int compare(final Breeder object1, final Breeder object2) {
                    return object1.getKennelname().compareTo(object2.getKennelname());
                }
            });

        }
        return allbreeders;
    }

    @CrossOrigin
    @RequestMapping(value = "/clubs", method = RequestMethod.GET)
    public List<Club> getClubs() {
        System.out.println("all Clubs");
        List<Club> allclubs = clubRepository.findAll();
        if (allclubs.size() > 0) {
            Collections.sort(allclubs, new Comparator<Club>() {
                @Override
                public int compare(final Club object1, final Club object2) {
                    return object1.getClubname().compareTo(object2.getClubname());
                }
            });

        }
        return allclubs;
    }

    @CrossOrigin
    @RequestMapping(value = "/judges", method = RequestMethod.GET)
    public List<Judge> getJudges() {
        System.out.println("all Judges");
        List<Judge> alljudges = judgeRepository.findAll();
        if (alljudges.size() > 0) {
            Collections.sort(alljudges, new Comparator<Judge>() {
                @Override
                public int compare(final Judge object1, final Judge object2) {
                    return object1.getLastname().compareTo(object2.getLastname());
                }
            });

        }
        return alljudges;
    }

    @CrossOrigin
    @RequestMapping(value = "/coursings/{coursing_class}/{gender}", method = RequestMethod.GET)
    public List<CoursingResult> getCoursings(@PathVariable String coursing_class, @PathVariable String gender) {
        System.out.println("all Coursings");
        // Receive a list of Dogid, Dogname and total number of participations
        List<TotalParticipation> totalparticipationcoursing;
        if (coursing_class.equalsIgnoreCase("international")) {
            totalparticipationcoursing = em.createNativeQuery("select coursing.dog_id, dog.name, count(coursing.tournament_id) AS total_participation from coursing JOIN dog ON dog.dog_id = coursing.dog_id WHERE coursing.coursing_class = '" + coursing_class + "' AND dog.sex = '" + gender + "' AND dog.race = 'Whippet'  GROUP BY  dog.name, coursing.dog_id", "totalparticipationcoursing").getResultList();
        } else if (coursing_class.equalsIgnoreCase("national")) {
            totalparticipationcoursing = em.createNativeQuery("select coursing.dog_id, dog.name, count(coursing.tournament_id) AS total_participation from coursing JOIN dog ON dog.dog_id = coursing.dog_id WHERE coursing.coursing_class = '" + coursing_class + "' AND dog.race = 'Whippet' GROUP BY  dog.name, coursing.dog_id", "totalparticipationcoursing").getResultList();
        } else {
            totalparticipationcoursing = em.createNativeQuery("select coursing.dog_id, dog.name, count(coursing.tournament_id) AS total_participation from coursing JOIN dog ON dog.dog_id = coursing.dog_id WHERE dog.race = 'Whippet' GROUP BY  dog.name, coursing.dog_id", "totalparticipationcoursing").getResultList();

        }
        // Extract collected data into CoursingResults
        List<CoursingResult> coursingResults = new ArrayList<>();
        for (int i = 0; i < totalparticipationcoursing.size(); i++) {
            CoursingResult coursingResult = new CoursingResult();
            Long totalParticipations = totalparticipationcoursing.get(i).getTotal_participation();
            // Long totalRatings = getTopFiveCoursingRatings(totalparticipationcoursing.get(i).getDog_id());

            //getestRatings(totalparticipationcoursing.get(i).getDog_id());

            coursingResult.setTotalParticipations(totalParticipations);
            //coursingResult.setDogname(totalparticipationcoursing.get(i).getName());
            coursingResult.setDogname(formatDogAndKennel(totalparticipationcoursing.get(i).getDog_id()));
            coursingResult.setTotalratings(getAverageOfBestRatings(totalparticipationcoursing.get(i).getDog_id()));
            if (totalParticipations > 5) {
                coursingResult.setMaxNoRatings(Integer.toUnsignedLong(5));
            } else {
                coursingResult.setMaxNoRatings(totalParticipations);
            }
            // If Owner exists add his/her firstname and lastname to CoursingResult
            if (dogRepository.findById(totalparticipationcoursing.get(i).getDog_id()).getOwner() != null) {
                Owner owner = dogRepository.findById(totalparticipationcoursing.get(i).getDog_id()).getOwner();
                coursingResult.setOwnername(owner.getFirstname() + " " + owner.getLastname());
            }
            coursingResults.add(coursingResult);
        }

        // Sort results regarding best ratings

        Collections.sort(coursingResults, new Comparator<CoursingResult>() {
            @Override
            public int compare(CoursingResult arg0, CoursingResult arg1) {

                if (arg0.getTotalratings() != null && arg1.getTotalratings() != null) {
                    return arg0.getTotalratings().compareTo(arg1.getTotalratings());
                }
                if (arg0.getTotalratings() == null) {
                    return 1;
                }
                return -1;
            }
        });

        Collections.reverse(coursingResults);


        for (int i = 0; i < coursingResults.size(); i++) {
            coursingResults.get(i).setRanking(Integer.toUnsignedLong(i + 1));
        }

        return coursingResults;
    }

    private String formatDogAndKennel(Long dogID) {
        Dog dog = dogRepository.getOne(dogID);

        if (dog.getBreeder() != null) {
            Breeder breeder = dog.getBreeder();
            if (breeder.getAffix().equalsIgnoreCase("prefix")) {
                return breeder.getKennelname() + ' ' + dog.getName();
            } else {
                return dog.getName() + ' ' + breeder.getKennelname();
            }
        } else {
            return dog.getName();
        }
    }
}
