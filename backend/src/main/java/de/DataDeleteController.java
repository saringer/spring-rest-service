package de;

import de.data_models.Dog;
import de.data_models.Judge;
import de.data_models.Tournament;
import de.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;



@RestController
@RequestMapping("/delete")
public class DataDeleteController {

    @Autowired
    DogRepository dogRepository;
    @Autowired
    TournamentRepository tournamentRepository;
    @Autowired
    JudgeRepository judgeRepository;
    @Autowired
    BreederRepository breederRepository;
    @Autowired
    ClubRepository clubRepository;
    @Autowired
    OwnerRepository ownerRepository;

    @CrossOrigin
    @DeleteMapping("/tournamentdog/{dog_id}/{tournament_id}")
    public void deleteTournamentDog(@PathVariable long dog_id, @PathVariable long tournament_id) {
        System.out.println("Delete dogID: " + dog_id + " tournamentId: " + tournament_id);
        Dog dog = dogRepository.findOne(dog_id);
        Tournament tournament = tournamentRepository.findOne(tournament_id);
        dog.deleteTournamentDog(tournament_id);
        tournamentRepository.save(tournament);
        dogRepository.save(dog);

    }
    @CrossOrigin
    @DeleteMapping("/tournamentjudge/{judge_id}/{tournament_id}")
    public void deleteTournamentJudge(@PathVariable long judge_id, @PathVariable long tournament_id) {
        Judge judge = judgeRepository.findOne(judge_id);
        Tournament tournament = tournamentRepository.findOne(tournament_id);
        tournament.removeJudge(judge_id);
        judgeRepository.save(judge);
        tournamentRepository.save(tournament);

    }
    @CrossOrigin
    @DeleteMapping("/breeder/{breeder_id}")
    public void deleteBreeder(@PathVariable long breeder_id) {
        breederRepository.delete(breeder_id);

    }
    @CrossOrigin
    @DeleteMapping("/club/{club_id}")
    public void deleteClub(@PathVariable long club_id) {
        clubRepository.delete(club_id);
    }

    @CrossOrigin
    @DeleteMapping("/owner/{club_id}")
    public void deleteOwner(@PathVariable long owner_id) {
        ownerRepository.delete(owner_id);
    }
}
