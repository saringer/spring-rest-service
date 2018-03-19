package de;

import de.data_models.*;
import de.repositories.*;
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
    @Autowired
    private JudgeRepository judgeRepository;
    @Autowired
    private DogRepository dogRepository;

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/tournament/{id}")
    public Tournament updateTournament(@PathVariable long id, @RequestBody Tournament request) {
        System.out.println("tournament update: " + request.getTitle());
        return tournamentRepository.save(request);
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/breeder/{id}")
    public Breeder updateBreeder(@PathVariable long id, @RequestBody Breeder request) {
        return breederRepository.save(request);
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/club/{id}")
    public Club updateClub(@PathVariable long id, @RequestBody Club request) {
        return clubRepository.save(request);
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/owner/{id}")
    public Owner updateOwner(@PathVariable long id, @RequestBody Owner request) {
        return ownerRepository.save(request);
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/judge/{id}")
    public Judge updateJudge(@PathVariable long id, @RequestBody Judge request) {
        return judgeRepository.save(request);
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/dog/{id}")
    public Dog updateDog(@PathVariable long id, @RequestBody Dog request) {
        System.out.println(request);
        return dogRepository.save(request);
    }

}
