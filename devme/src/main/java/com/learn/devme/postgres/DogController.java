package com.learn.devme.postgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/dog")
public class DogController {
    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService){

        this.dogService = dogService;
    }
    @GetMapping
    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

    @PostMapping
    public void registerOwner(@RequestBody Dog dog){
        dogService.addNewDog(dog);
    }

    @DeleteMapping(path = "{dogId}")
    public void deleteDOg(@PathVariable("dogId") Long dogId){
        dogService.deleteDog(dogId);
    }

//    @PutMapping(path = "{dogId}")
//    public void updateOwner(@PathVariable("dogId") Long dogId,
//                            @RequestParam(required = false) String breed_name,
//                            @RequestBody(required = false) String breed_name){
//        dogService.updateDog(dogId, breed_name);
//    }
}
