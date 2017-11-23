package de;

import java.util.concurrent.atomic.AtomicLong;

import de.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/save")
public class DogpassController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private DogRepository dogRepository;

   // @RequestMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dog greeting(@RequestBody Dog request) {
        System.out.println("kam an json" + request.getName());
        dogRepository.save(request);
        return new Dog();
    }
    // @RequestMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Dog greeting2(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("kam an text");
        return new Dog();
    }
}
