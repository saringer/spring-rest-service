package de.repositories;

import de.data_models.Owner;
import de.data_models.Tournament;
import de.data_models.TournamentDog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TournamentDogRepository extends JpaRepository<TournamentDog, Long> {

    List<TournamentDog> findAll();
    TournamentDog save(TournamentDog tournamentDog);

}
