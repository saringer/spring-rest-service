package de.repositories;

import de.data_models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {

    List<Dog> findByName(String name);



    Dog save(Dog dog);


}
