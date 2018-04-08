package de.data_retrieve_controller;

import de.data_access_objects.coursing.Rating;
import de.data_access_objects.coursing.TotalParticipation;
import de.data_models.Breeder;
import de.data_models.Dog;
import de.data_models.Owner;
import de.data_transfer_objects.CoursingResult;
import de.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/get")
public class CoursingController {
    @Autowired
    private DogRepository dogRepository;
    @Autowired
    EntityManager em;


    @CrossOrigin
    @RequestMapping(value = "/coursings/{coursing_class}/{gender}/{year}", method = RequestMethod.GET)
    public List<CoursingResult> getCoursings(@PathVariable String coursing_class, @PathVariable String gender, @PathVariable String year) {
        System.out.println("all Coursings");
        // Receive a list of Dogid, Dogname and total number of participations
        List<TotalParticipation> totalparticipationcoursing;
        if (coursing_class.equalsIgnoreCase("international")) {
            totalparticipationcoursing = em.createNativeQuery("select coursing.dog_id, dog.name, count(coursing.tournament_id) AS total_participation from coursing JOIN dog ON dog.dog_id = coursing.dog_id JOIN tournament ON tournament.tournament_id = coursing.tournament_id WHERE coursing.coursing_class = '" + coursing_class + "' AND dog.sex = '" + gender + "' AND dog.race = 'Whippet' AND to_char(tournament.date, 'YYYY') = '" + year + "'  GROUP BY  dog.name, coursing.dog_id", "totalparticipationcoursing").getResultList();
        } else if (coursing_class.equalsIgnoreCase("national")) {
            totalparticipationcoursing = em.createNativeQuery("select coursing.dog_id, dog.name, count(coursing.tournament_id) AS total_participation from coursing JOIN dog ON dog.dog_id = coursing.dog_id JOIN tournament ON tournament.tournament_id = coursing.tournament_id WHERE coursing.coursing_class = '" + coursing_class + "' AND dog.race = 'Whippet' AND to_char(tournament.date, 'YYYY') = '" + year + "' GROUP BY  dog.name, coursing.dog_id", "totalparticipationcoursing").getResultList();
        } else {
            totalparticipationcoursing = em.createNativeQuery("select coursing.dog_id, dog.name, count(coursing.tournament_id) AS total_participation from coursing JOIN dog ON dog.dog_id = coursing.dog_id JOIN tournament ON tournament.tournament_id = coursing.tournament_id WHERE dog.race = 'Whippet' AND to_char(tournament.date, 'YYYY') = '" + year + "' GROUP BY  dog.name, coursing.dog_id", "totalparticipationcoursing").getResultList();

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
            coursingResult.setTotalratings(getAverageOfBestRatings(totalparticipationcoursing.get(i).getDog_id(), coursing_class));
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

    private String getAverageOfBestRatings(Long dog_id, String coursing_class) {
        Integer double_weighted_couter = 0;
        Double sum = 0.0;
        List<Rating> ratings;
        if (coursing_class.equalsIgnoreCase("all")) {
            ratings = (List<Rating>) em.createNativeQuery("SELECT coursing.coursing_rating, tournament.double_weighted FROM coursing JOIN tournament ON tournament.tournament_id = coursing.tournament_id WHERE coursing.dog_id = " + dog_id + "  ORDER BY coursing.coursing_rating DESC LIMIT 5", "ratings").getResultList();
        } else {
            ratings = (List<Rating>) em.createNativeQuery("SELECT coursing.coursing_rating, tournament.double_weighted FROM coursing JOIN tournament ON tournament.tournament_id = coursing.tournament_id WHERE coursing.dog_id = " + dog_id + " AND coursing.coursing_class = '" + coursing_class + "'  ORDER BY coursing.coursing_rating DESC LIMIT 5", "ratings").getResultList();
        }
        // minimum 5 coursings to be part of the competition
        if (ratings.size() > 4) {
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
            return String.format("%.3f", sum / (ratings.size() + double_weighted_couter));
        } else {
            return String.format("%.3f", sum);
        }
    }

}