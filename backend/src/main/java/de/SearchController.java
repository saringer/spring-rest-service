package de;

import de.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private DogRepository dogRepository;

    // @RequestMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dog greeting(@RequestBody String request) {
        System.out.println("kam an json" + request);
        //dogRepository.save(request);
        return new Dog();
    }
    // @RequestMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.TEXT_PLAIN_VALUE)
    public String greeting2(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("search");
        return "asdsad";
    }
}
