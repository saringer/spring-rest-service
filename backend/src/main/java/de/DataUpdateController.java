package de;

import de.data_models.*;
import de.repositories.BreederRepository;
import de.repositories.ClubRepository;
import de.repositories.OwnerRepository;
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
    @Autowired
    private OwnerRepository ownerRepository;

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/tournament/{id}")
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
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/owner/{id}")
    public Owner updateOwnerJson(@PathVariable long id, @RequestBody Owner request) {
        return ownerRepository.save(request);
    }

}
