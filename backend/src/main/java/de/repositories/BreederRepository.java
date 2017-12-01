package de.repositories;

import de.data_models.Breeder;
import de.data_models.Dog;
import de.data_models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreederRepository extends JpaRepository<Breeder, Long> {

    List<Breeder> findAll();



    Breeder save(Breeder breeder);
}
