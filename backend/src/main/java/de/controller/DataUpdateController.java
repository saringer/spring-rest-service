package de.controller;

import de.data_models.entities.*;
import de.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

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
    @Autowired
    private EntityManager em;

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
    @PutMapping("/racedistance/{dogID}/{tournamentID}")
    @Transactional
    public void updateRaceDistance(@PathVariable long dogID, @PathVariable long tournamentID, @RequestBody String distance) {
        em.joinTransaction();
        em.createNativeQuery("UPDATE race SET distance = '" + distance + "' WHERE dog_id = " + dogID + " AND tournament_id = " + tournamentID).executeUpdate();
        //return judgeRepository.save(request);

    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/dog/{id}")
    public Dog updateDog(@PathVariable long id, @RequestBody Dog request) {
        Dog fetchedDog = dogRepository.findById(request.getId());
        fetchedDog.setName(request.getName());
        fetchedDog.setRace(request.getRace());
        fetchedDog.setSex(request.getSex());
        fetchedDog.setPassport_number(request.getPassport_no());
        fetchedDog.setChip_no(request.getChip_no());
        fetchedDog.setCoat_colour(request.getCoat_colour());
        fetchedDog.setBreeder(request.getBreeder());
        fetchedDog.setOwner(request.getOwner());
        fetchedDog.setDate_of_birth(request.getDate_of_birth());
        System.out.println(request);
        return dogRepository.save(fetchedDog);
    }

}
