package de.controller.data_retrieve_controller;


import de.data_models.data_transfer_objects.RaceDTO;
import de.data_models.entities.Breeder;
import de.data_models.entities.Dog;
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
