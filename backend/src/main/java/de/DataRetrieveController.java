package de;

import de.data_access_objects.SumOfTopFiveRatings;
import de.data_access_objects.TotalParticipation;
import de.data_models.*;
import de.data_transfer_objects.CoursingResult;

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


    private Long getTopFiveCoursingRatings(Long dog_id) {
        SumOfTopFiveRatings sum = (SumOfTopFiveRatings) em.createNativeQuery("SELECT SUM(coursing_rating) FROM (SELECT coursing.coursing_rating FROM coursing WHERE coursing.dog_id = " + dog_id + " ORDER BY coursing.coursing_rating DESC LIMIT 5) AS subquery", "sumOfTopFiveRatings").getSingleResult();
        return  sum.getSum();
    }

    private Long getAverage(Long totalRatings, Long participations) {
        Long result = null;
        if (totalRatings > 0) {
            if (participations > 5) {
                result = totalRatings / 5;
            }
            else {
                result = totalRatings / participations;

            }
        }
        return result;
    }


    @CrossOrigin
    @RequestMapping(value = "/dog/{dog_id}",method = RequestMethod.GET)
    public Dog getDog(@PathVariable long dog_id) {
        System.out.println(dog_id);
        return dogRepository.findById(dog_id);
    }
    @CrossOrigin
    @RequestMapping(value = "/dogs",method = RequestMethod.GET)
    public List<Dog> getDogs() {
        System.out.println("all dogs");
        return dogRepository.findAll();
    }
    @CrossOrigin
    @RequestMapping(value = "/tournamentdogs/{id}",method = RequestMethod.GET)
    public List<Coursing> getTournamentDog(@PathVariable long id) {
        System.out.println("all tournamentdogs");
        if (tournamentRepository.findById(id) !=null) {
            return tournamentRepository.findById(id).getCoursings();
        }
        else return null;
        //return tournamentRepository.findOne(id).getCoursings();
    }
    @CrossOrigin
    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    public List<Owner> getOwners() {
        System.out.println("all owners");
        return ownerRepository.findAll();
    }
    @CrossOrigin
    @RequestMapping(value = "/tournament/{tournament_id}",method = RequestMethod.GET)
    public Tournament getTournament(@PathVariable long tournament_id) {
        System.out.println(tournament_id);
        return tournamentRepository.findById(tournament_id);
    }
    @CrossOrigin
    @RequestMapping(value = "/tournaments", method = RequestMethod.GET)
    public List<Tournament> getTournaments() {
        System.out.println("all tournaments");
        return tournamentRepository.findAll();
    }
    @CrossOrigin
    @RequestMapping(value = "/breeders", method = RequestMethod.GET)
    public List<Breeder> getBreeders() {
        System.out.println("all Breeder");
        return breederRepository.findAll();
    }
    @CrossOrigin
    @RequestMapping(value = "/clubs", method = RequestMethod.GET)
    public List<Club> getClubs() {
        System.out.println("all Clubs");
        return clubRepository.findAll();
    }
    @CrossOrigin
    @RequestMapping(value = "/judges", method = RequestMethod.GET)
    public List<Judge> getJudges() {
        System.out.println("all Judges");
        return judgeRepository.findAll();
    }
    @CrossOrigin
    @RequestMapping(value = "/coursings/{coursing_class}/{gender}", method = RequestMethod.GET)
    public List<CoursingResult> getCoursings(@PathVariable String coursing_class, @PathVariable String gender) {
        System.out.println("all Coursings");
        // Receive a list of Dogid, Dogname and total number of participations
        List<TotalParticipation> totalparticipationcoursing;
        if (coursing_class.equalsIgnoreCase("international")) {
            totalparticipationcoursing = em.createNativeQuery("select coursing.dog_id, dog.name, count(coursing.tournament_id) AS total_participation from coursing JOIN dog ON dog.dog_id = coursing.dog_id WHERE coursing.coursing_class = '" + coursing_class + "' AND dog.sex = '" + gender + "' AND dog.race = 'Whippet'  GROUP BY  dog.name, coursing.dog_id", "totalparticipationcoursing").getResultList();
        }
        else if (coursing_class.equalsIgnoreCase("national")) {
            totalparticipationcoursing = em.createNativeQuery("select coursing.dog_id, dog.name, count(coursing.tournament_id) AS total_participation from coursing JOIN dog ON dog.dog_id = coursing.dog_id WHERE coursing.coursing_class = '" + coursing_class + "' AND dog.race = 'Whippet' GROUP BY  dog.name, coursing.dog_id", "totalparticipationcoursing").getResultList();
        }
        else {
            totalparticipationcoursing = em.createNativeQuery("select coursing.dog_id, dog.name, count(coursing.tournament_id) AS total_participation from coursing JOIN dog ON dog.dog_id = coursing.dog_id WHERE dog.race = 'Whippet' GROUP BY  dog.name, coursing.dog_id", "totalparticipationcoursing").getResultList();

        }
        // Extract collected data into CoursingResults
        List<CoursingResult> coursingResults = new ArrayList<>();
        for (int i=0; i<totalparticipationcoursing.size();i++) {
            CoursingResult coursingResult = new CoursingResult();
            Long totalParticipations = totalparticipationcoursing.get(i).getTotal_participation();
            Long totalRatings = getTopFiveCoursingRatings(totalparticipationcoursing.get(i).getDog_id());


            coursingResult.setTotalParticipations(totalParticipations);
            coursingResult.setDogname(totalparticipationcoursing.get(i).getName());
            coursingResult.setTotalratings(getAverage(totalRatings,totalParticipations));
            if (totalParticipations > 5) {
                coursingResult.setMaxNoRatings(Integer.toUnsignedLong(5));
            }
            else {
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
       /*Collections.sort(coursingResults, new Comparator<CoursingResult>() {
            @Override
            public int compare(CoursingResult fruit2, CoursingResult fruit1)
            {

                return  fruit1.getTotalratings().compareTo(fruit2.getTotalratings());
            }
        });*/
        // Add ranking
        Collections.reverse(coursingResults);


        for (int i=0;i<coursingResults.size();i++) {
            coursingResults.get(i).setRanking(Integer.toUnsignedLong(i+1));
        }

        return coursingResults;
    }
}
