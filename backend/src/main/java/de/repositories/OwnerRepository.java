package de.repositories;

import de.data_models.Dog;
import de.data_models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    List<Owner> findAll();
    Owner save(Owner owner);

}
