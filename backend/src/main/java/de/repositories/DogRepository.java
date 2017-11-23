package de.repositories;

import de.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {

    List<Dog> findByName(String name);



    Dog save(Dog dog);


}
