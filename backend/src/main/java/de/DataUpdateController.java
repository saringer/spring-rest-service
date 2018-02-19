package de;

import de.data_models.Judge;
import de.data_models.Tournament;
import de.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update")
public class DataUpdateController {

    @Autowired
    private TournamentRepository tournamentRepository;

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/tournaments/{id}")
    public Tournament updateTournamentJson(@PathVariable long id, @RequestBody Tournament request) {
        System.out.println("tournament update: " + request.getTitle() + " Ist Empty? " + request.getParticipating_dogs().isEmpty());
        return tournamentRepository.save(request);
    }

}
