package de;

import de.data_models.Dog;
import de.data_models.Owner;
import de.data_models.Tournament;
import de.repositories.DogRepository;
import de.repositories.OwnerRepository;
import de.repositories.TournamentRepository;
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
}
