package de;

import de.data_models.Dog;
import de.data_models.Judge;
import de.data_models.Tournament;
import de.repositories.DogRepository;
import de.repositories.JudgeRepository;
import de.repositories.TournamentRepository;
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
}
