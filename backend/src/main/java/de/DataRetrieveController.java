package de;

import de.data_models.*;
import de.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/dogs",method = RequestMethod.GET)
    public List<Dog> getDogs() {
        System.out.println("all dogs");
        return dogRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    public List<Owner> getOwners() {
        System.out.println("all owners");
        return ownerRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/tournaments", method = RequestMethod.GET)
    public List<Tournament> getTournaments() {
        System.out.println("all tournaments");
        return tournamentRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/breeders", method = RequestMethod.GET)
    public List<Breeder> getBreeders() {
        System.out.println("all Breeder");
        return breederRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/clubs", method = RequestMethod.GET)
    public List<Club> getClubs() {
        System.out.println("all Clubs");
        return clubRepository.findAll();
    }
}
