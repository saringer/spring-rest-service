package de;

import java.util.concurrent.atomic.AtomicLong;

import de.data_models.Breeder;
import de.data_models.Dog;
import de.data_models.Owner;
import de.data_models.Tournament;
import de.repositories.BreederRepository;
import de.repositories.DogRepository;
import de.repositories.OwnerRepository;
import de.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/save")
public class DataStoreController {


    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private BreederRepository breederRepository;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/dog", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dog saveDogJson(@RequestBody Dog request) {
        System.out.println("kam an json" + request.getName() + " OwnerID: " + request.getOwner());
        dogRepository.save(request);
        return new Dog();
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/dog", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Dog saveDogPlainText(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("kam an text");
        return new Dog();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/owner", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Owner saveOwnerJson(@RequestBody Owner request) {
        System.out.println("kam an owner" + request.getFirstname());
        ownerRepository.save(request);
        return new Owner();
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/owner", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Owner saveOwnerPlainText(@RequestBody Owner request) {
        System.out.println("kam an owner" + request.getFirstname());
        ownerRepository.save(request);
        return new Owner();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/tournament", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tournament saveTournamentJson(@RequestBody Tournament request) {
        System.out.println("kam an tournament" + request.getTitle());
        tournamentRepository.save(request);
        return new Tournament();
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/tournament", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Tournament saveTournamentPlainText(@RequestBody Tournament request) {
        System.out.println("kam an tournament" + request.getTitle());
        tournamentRepository.save(request);
        return new Tournament();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/breeder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Breeder saveTournamentJson(@RequestBody Breeder request) {
        System.out.println("kam an tournament" + request.getKennelname());
        breederRepository.save(request);
        return new Breeder();
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/breeder", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Breeder saveTournamentPlainText(@RequestBody Breeder request) {
        System.out.println("kam an tournament" + request.getKennelname());
        breederRepository.save(request);
        return new Breeder();
    }
}
