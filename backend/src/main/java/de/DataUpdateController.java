package de;

import de.data_models.Breeder;
import de.data_models.Club;
import de.data_models.Judge;
import de.data_models.Tournament;
import de.repositories.BreederRepository;
import de.repositories.ClubRepository;
import de.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update")
public class DataUpdateController {

    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private BreederRepository breederRepository;
    @Autowired
    private ClubRepository clubRepository;

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/tournaments/{id}")
    public Tournament updateTournamentJson(@PathVariable long id, @RequestBody Tournament request) {
        System.out.println("tournament update: " + request.getTitle());
        return tournamentRepository.save(request);
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/breeder/{id}")
    public Breeder updateBreederJson(@PathVariable long id, @RequestBody Breeder request) {
        return breederRepository.save(request);
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/club/{id}")
    public Club updateClubJson(@PathVariable long id, @RequestBody Club request) {
        return clubRepository.save(request);
    }

}
