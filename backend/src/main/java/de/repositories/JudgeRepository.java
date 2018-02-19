package de.repositories;

import de.data_models.Judge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JudgeRepository extends JpaRepository<Judge, Long> {

    List<Judge> findAll();
    Judge save(Judge judge);

}
