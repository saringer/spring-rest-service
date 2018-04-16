package de.repositories;

import de.data_models.entities.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {

    List<Dog> findByName(String name);
    List<Dog> findAll();
    Dog findById(Long id);




    Dog save(Dog dog);


}
