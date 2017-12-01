package de.repositories;

import de.data_models.Club;
import de.data_models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club,Long> {
    List<Club> findAll();
    Club save(Club club);
}
