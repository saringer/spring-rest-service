package de;

import de.data_models.*;
import de.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/save")
//@CrossOrigin(origins = "http://localhost:4200/admin", maxAge = 3600)
public class DataStoreController {


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


    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/dog", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dog saveDogJson(@RequestBody Dog request) {
        System.out.println("kam an json" + request.getName() + " OwnerID: " + request.getOwner().getFirstname());
        return dogRepository.save(request);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/dog", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Dog saveDogPlainText(@RequestBody Dog request) {
        return dogRepository.save(request);
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/tournamentdog", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveTournamentDogJson(@RequestBody TournamentDog request) {
        Dog dog = dogRepository.findOne(request.getDog().getId());
        Tournament tournament = tournamentRepository.findOne(request.getTournament().getId());
        dog.addTournamentDog(request);
        tournamentRepository.save(tournament);
        dogRepository.save(dog);



    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/tournamentdog", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public void saveTournamentDogPlainText(@RequestBody TournamentDog request) {
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/owner", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Owner saveOwnerJson(@RequestBody Owner request) {
        return ownerRepository.save(request);
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/owner", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Owner saveOwnerPlainText(@RequestBody Owner request) {
        return ownerRepository.save(request);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/tournament", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tournament saveTournamentJson(@RequestBody Tournament request) {
        return tournamentRepository.save(request);
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/tournament", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Tournament saveTournamentPlainText(@RequestBody Tournament request) {
        System.out.println("kam an tournament" + request.getTitle());
        return tournamentRepository.save(request);
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/breeder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Breeder saveBreederJson(@RequestBody Breeder request) {
        System.out.println("kam an breeder: " + request.getKennelname());
        return breederRepository.save(request);
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/breeder", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Breeder saveBreederPlainText(@RequestBody Breeder request) {
        System.out.println("kam an breeder" + request.getKennelname());
        return breederRepository.save(request);

    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/club", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Club saveClubPlainText(@RequestBody Club request) {
        System.out.println("kam an club" + request.getClubname());
        return clubRepository.save(request);

    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/club", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Club saveClubJson(@RequestBody Club request) {
        System.out.println("kam an club" + request.getClubname());
        return clubRepository.save(request);
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/judge", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Judge saveJudgePlainText(@RequestBody Judge request) {
        System.out.println("kam an judge: " + request.getFirstname());
        return judgeRepository.save(request);

    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/judge", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Judge saveJudgeJson(@RequestBody Judge request) {
        System.out.println("kam an judge: " + request.getFirstname());
        return judgeRepository.save(request);
    }
}
