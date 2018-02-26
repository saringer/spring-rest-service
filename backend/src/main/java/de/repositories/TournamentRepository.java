package de.repositories;

import de.data_models.Owner;
import de.data_models.Tournament;
import de.data_models.TournamentDog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    List<Tournament> findAll();
    Tournament save(Tournament tournament);
    Tournament findById(Long id);

}
