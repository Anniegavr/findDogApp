package com.learn.devme.service;
import com.learn.devme.models.Dog;
import com.learn.devme.dao.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {
    private final DogRepository dogRepository;

    @Autowired
    public DogService(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public List<Dog> getAllDogs(){return dogRepository.findAll();}

    public void addNewDog(Dog dog) {
        Optional<Dog> dogOptional = dogRepository.findDogByName(dog.getName());
        if (dogOptional.isPresent()){
            throw new IllegalStateException("You've already saved it");
        }
        dogRepository.save(dog);
    }

    public void deleteDog(Long dogId) {
        boolean exists = dogRepository.existsById(dogId);
        if (!exists){
            throw new IllegalStateException("a dog breed with the id "+dogId+" doesn't exist");
        }
        dogRepository.deleteById(dogId);
    }

    public void updateDog(Long dogId, String breed_name) {
    }

//    @Transactional
//    public void updateOwner(Long ownerId, String name, String password) {
//        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new IllegalStateException(
//                "owner with id "+ownerId+" doesn't exist"));
//        if ((name != null) && (name.length() > 0) && !Objects.equals(owner.getName(), name)){
//            owner.setName(name);
//        }
//        if ((password != null) && (password.length() > 0) && !Objects.equals(owner.getPassword(), password)){
//            dog.setPassword(password);
//        }
//    }

}
