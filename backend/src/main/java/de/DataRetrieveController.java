package de;

import de.data_models.*;
import de.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    @Autowired
    private JudgeRepository judgeRepository;
    //Autowired
    //private TournamentDogRepository tournamentDogRepository;
    @Autowired
    EntityManager em;



    @CrossOrigin
    @RequestMapping(value = "/dog/{dog_id}",method = RequestMethod.GET)
    public Dog getDog(@PathVariable long dog_id) {
        System.out.println(dog_id);
        return dogRepository.findById(dog_id);
    }
    @CrossOrigin
    @RequestMapping(value = "/dogs",method = RequestMethod.GET)
    public List<Dog> getDogs() {
        System.out.println("all dogs");
        return dogRepository.findAll();
    }
    @CrossOrigin
    @RequestMapping(value = "/tournamentdogs/{id}",method = RequestMethod.GET)
    public List<TournamentDog> getTournamentDog(@PathVariable long id) {
        System.out.println("all tournamentdogs");
        if (tournamentRepository.findById(id) !=null) {
            return tournamentRepository.findById(id).getTournamentDogs();
        }
        else return null;
        //return tournamentRepository.findOne(id).getTournamentDogs();
    }
    @CrossOrigin
    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    public List<Owner> getOwners() {
        System.out.println("all owners");
        return ownerRepository.findAll();
    }
    @CrossOrigin
    @RequestMapping(value = "/tournament/{tournament_id}",method = RequestMethod.GET)
    public Tournament getTournament(@PathVariable long tournament_id) {
        System.out.println(tournament_id);
        return tournamentRepository.findById(tournament_id);
    }
    @CrossOrigin
    @RequestMapping(value = "/tournaments", method = RequestMethod.GET)
    public List<Tournament> getTournaments() {
        System.out.println("all tournaments");
        return tournamentRepository.findAll();
    }
    @CrossOrigin
    @RequestMapping(value = "/breeders", method = RequestMethod.GET)
    public List<Breeder> getBreeders() {
        System.out.println("all Breeder");
        return breederRepository.findAll();
    }
    @CrossOrigin
    @RequestMapping(value = "/clubs", method = RequestMethod.GET)
    public List<Club> getClubs() {
        System.out.println("all Clubs");
        return clubRepository.findAll();
    }
    @CrossOrigin
    @RequestMapping(value = "/judges", method = RequestMethod.GET)
    public List<Judge> getJudges() {
        System.out.println("all Judges");
        return judgeRepository.findAll();
    }
}
