package de;

import java.util.concurrent.atomic.AtomicLong;

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

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/dog", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveDogJson(@RequestBody Dog request) {
        System.out.println("kam an json" + request.getName() + " OwnerID: " + request.getOwner());
        dogRepository.save(request);
       // return new Dog();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/dog", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public void saveDogPlainText(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("kam an text");
        //return new Dog();
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/owner", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOwnerJson(@RequestBody Owner request) {
        System.out.println("kam an owner" + request.getFirstname());
        ownerRepository.save(request);
        //return new Owner();
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/owner", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public void saveOwnerPlainText(@RequestBody Owner request) {
        System.out.println("kam an owner" + request.getFirstname());
        ownerRepository.save(request);
       // return new Owner();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/tournament", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tournament saveTournamentJson(@RequestBody Tournament request) {
        System.out.println("kam an tournament" + request.getTitle());
        tournamentRepository.save(request);
        return new Tournament();
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/tournament", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Tournament saveTournamentPlainText(@RequestBody Tournament request) {
        System.out.println("kam an tournament" + request.getTitle());
        tournamentRepository.save(request);
        return new Tournament();
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/breeder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Breeder saveBreederJson(@RequestBody Breeder request) {
        System.out.println("kam an bbreeder" + request.getKennelname());
        breederRepository.save(request);
        return new Breeder();
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/breeder", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Breeder saveBreederPlainText(@RequestBody Breeder request) {
        System.out.println("kam an breeder" + request.getKennelname());
        breederRepository.save(request);
        return new Breeder();
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/club", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Club saveClubPlainText(@RequestBody Club request) {
        System.out.println("kam an club" + request.getClubname());
        clubRepository.save(request);
        return new Club();
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/club", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Club saveClubJson(@RequestBody Club request) {
        System.out.println("kam an club" + request.getClubname());
        clubRepository.save(request);
        return new Club();
    }
}
