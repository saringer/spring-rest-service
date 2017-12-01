package de.repositories;

import de.data_models.Owner;
import de.data_models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    List<Tournament> findAll();
    Tournament save(Tournament tournament);
}
