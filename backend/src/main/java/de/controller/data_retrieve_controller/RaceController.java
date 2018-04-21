package de.controller.data_retrieve_controller;


import de.data_models.data_access_objects.coursing.CoursingDetail;
import de.data_models.data_access_objects.coursing.Rating;
import de.data_models.data_access_objects.coursing.TotalParticipationCoursing;
import de.data_models.data_access_objects.race.RaceDetail;
import de.data_models.data_access_objects.race.RaceRating;
import de.data_models.data_access_objects.race.TotalParticipationRace;
import de.data_models.data_transfer_objects.CoursingResult;
import de.data_models.data_transfer_objects.RaceDTO;
import de.data_models.data_transfer_objects.RaceResult;
import de.data_models.entities.Breeder;
import de.data_models.entities.Dog;
import de.data_models.entities.Owner;
import de.data_models.entities.Race;
import de.repositories.DogRepository;
import de.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/get")
public class RaceController {

    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    EntityManager em;


    @CrossOrigin
    @RequestMapping(value = "/races/{race_class}/{dog_gender}/{year}", method = RequestMethod.GET)
    public List<RaceResult> getRaces(@PathVariable String race_class, @PathVariable String dog_gender,
                                     @PathVariable String year) {
        System.out.println("all Races");
        // Receive a list of Dogid, Dogname and total number of participations
        List<TotalParticipationRace> totalparticipationrace;

        totalparticipationrace = em.createNativeQuery("select race.dog_id, dog.name, count(race.tournament_id) AS total_participation from race JOIN dog ON dog.dog_id = race.dog_id JOIN tournament ON tournament.tournament_id = race.tournament_id WHERE race.race_class = '" + race_class + "' AND dog.sex = '" + dog_gender + "' AND dog.race = 'Whippet' AND to_char(tournament.date, 'YYYY') = '" + year + "'  GROUP BY  dog.name, race.dog_id", "totalparticipationrace").getResultList();


        // Extract collected data into CoursingResults
        List<RaceResult> raceResults = new ArrayList<>();
        for (int i = 0; i < totalparticipationrace.size(); i++) {
            RaceResult raceResult = new RaceResult();
            Long totalParticipations = totalparticipationrace.get(i).getTotal_participation();
            // Long totalRatings = getTopFiveCoursingRatings(totalparticipationcoursing.get(i).getDog_id());

            //getestRatings(totalparticipationcoursing.get(i).getDog_id());
            raceResult.setDog_id(totalparticipationrace.get(i).getDog_id());
            raceResult.setTotalParticipations(totalParticipations);
            //coursingResult.setDogname(totalparticipationcoursing.get(i).getName());
            raceResult.setDogname(formatDogAndKennel(totalparticipationrace.get(i).getDog_id()));
            //coursingResult.setTotalratings(getAverageOfBestRatingsAndSetMaxNoRating(totalparticipationcoursing.get(i).getDog_id(), coursing_class));
            getTopFiveBestRatingsAndSetMaxNoRating(totalparticipationrace.get(i).getDog_id(), race_class, raceResult);

            /*if (totalParticipations > 5) {
                coursingResult.setMaxNoRatings(Integer.toUnsignedLong(5));
            } else {
                coursingResult.setMaxNoRatings(totalParticipations);
            }*/
            // If Owner exists add his/her firstname and lastname to CoursingResult
            if (dogRepository.findById(totalparticipationrace.get(i).getDog_id()).getOwner() != null) {
                Owner owner = dogRepository.findById(totalparticipationrace.get(i).getDog_id()).getOwner();
                raceResult.setOwnername(owner.getFirstname() + " " + owner.getLastname());
            }
            raceResults.add(raceResult);
        }

        // Sort results regarding best ratings

       /* Collections.sort(raceResults, new Comparator<RaceResult>() {
            @Override
            public int compare(RaceResult arg0, RaceResult arg1) {

                if (arg0.getTotalPoints() != null && arg1.getTotalPoints() != null) {
                    return arg0.getTotalPoints().compareTo(arg1.getTotalPoints());
                }
                if (arg0.getTotalPoints() == null) {
                    return 1;
                }
                return -1;
            }
        });

        Collections.reverse(raceResults);*/
        Collections.sort(raceResults, Collections.reverseOrder(new RaceResultComparator()));


        for (int i = 0; i < raceResults.size(); i++) {
            raceResults.get(i).setRanking(Integer.toUnsignedLong(i + 1));
        }

        return raceResults;
    }


    @CrossOrigin
    @RequestMapping(value = "/races/{id}", method = RequestMethod.GET)
    public List<RaceDTO> getRacesForTournament(@PathVariable long id) {
        System.out.println("all races");
        if (tournamentRepository.findById(id) != null) {
            List<RaceDTO> dtoList = new ArrayList<>();

            List<Race> races = tournamentRepository.findById(id).getRaces();
            for (int i = 0; i < races.size(); i++) {
                RaceDTO dto = new RaceDTO();
                dto.setDogname(formatDogAndKennel(races.get(i).getDog().getId()));
                dto.setNotfinished(races.get(i).isNotfinished());
                dto.setNotstarted(races.get(i).isNotstarted());
                dto.setWithdrawn(races.get(i).isWithdrawn());
                dto.setInjured(races.get(i).isInjured());
                dto.setDisqualified(races.get(i).isDisqualified());
                dto.setRaceTime(races.get(i).getRaceTime());
                dto.setTournamentid(id);
                dto.setTournament(races.get(i).getTournament());
                dto.setDog(races.get(i).getDog());
                dto.setDistance(races.get(i).getDistance());
                dto.setRaceClass(races.get(i).getRaceClass());
                dto.setPoints(races.get(i).getPoints());
                dtoList.add(dto);
            }
            Collections.sort(dtoList, new Comparator<RaceDTO>() {
                @Override
                public int compare(RaceDTO arg0, RaceDTO arg1) {

                    if (arg0.getRaceClass() != null && arg1.getRaceClass() != null) {
                        return arg0.getRaceClass().compareTo(arg1.getRaceClass());
                    }
                    if (arg0.getRaceClass() == null) {
                        return 1;
                    }
                    return -1;
                }
            });
            return dtoList;
        } else return null;
        //return tournamentRepository.findOne(id).getCoursings();
    }

    @CrossOrigin
    @RequestMapping(value = "/racesAndEvaluations/{dog_id}", method = RequestMethod.GET)
    public List<RaceDTO> getAllRacesAndEvaluations(@PathVariable long dog_id) {

        return null;
    }

    @CrossOrigin
    @RequestMapping(value = "/racedetails/{dog_id}/{year}", method = RequestMethod.GET)
    public List<RaceDetail> getRaceDetailsForDog(@PathVariable long dog_id, @PathVariable String year) {
        System.out.println("get racedetails");
        List<RaceDetail> raceDetails = em.createNativeQuery("SELECT  tournament.title, points, tournament.double_weighted, notstarted, notfinished, injured, withdrawn, disqualified FROM race JOIN tournament ON tournament.tournament_id = race.tournament_id WHERE race.dog_id = " + dog_id + " AND to_char(tournament.date, 'YYYY') = '" + year + "'", "racedetails").getResultList();
        return raceDetails;

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

    private void getTopFiveBestRatingsAndSetMaxNoRating(Long dog_id, String race_class, RaceResult raceResult) {
        Integer sum = 0;
        List<RaceRating> ratings;
        ratings = (List<RaceRating>) em.createNativeQuery("SELECT race.points, tournament.double_weighted FROM race JOIN tournament ON tournament.tournament_id = race.tournament_id WHERE race.dog_id = " + dog_id + " AND race.race_class = '" + race_class + "' " +
                "AND race.notfinished = false AND race.notstarted = false AND race.withdrawn = false \n" +
                "AND race.injured = false AND race.disqualified = false AND race.points > 0 ORDER BY race.points DESC LIMIT 5", "raceratings").getResultList();


        Integer racesInCalculation = 0;

        for (int i = 0; i < ratings.size(); i++) {
            if (racesInCalculation == 5) {
                break;
            } else {

                if (ratings.get(i).getPoints() != null) {
                    if (ratings.get(i).isDouble_weighted()) {
                        if (racesInCalculation <= 3) {
                            racesInCalculation = racesInCalculation + 2;
                            sum = sum + (ratings.get(i).getPoints() * 2);
                        } else {
                            racesInCalculation = racesInCalculation + 1;
                            sum = sum + (ratings.get(i).getPoints());
                        }

                    } else {
                        racesInCalculation = racesInCalculation + 1;
                        sum = sum + ratings.get(i).getPoints();

                    }
                }
            }
        }

        //return String.format("%.3f", sum / (ratings.size() + double_weighted_couter));
        raceResult.setTotalPoints(Integer.toString(sum));
        raceResult.setMaxNoRatings(Integer.toUnsignedLong(racesInCalculation));


    }


}
