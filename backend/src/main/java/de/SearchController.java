package de;

import de.data_models.Dog;
import de.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class SearchController {

    @Autowired
    private DogRepository dogRepository;


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET)
    public List<Dog> getDogs() {
        System.out.println("all dogs");
        return dogRepository.findAll();
    }
}
