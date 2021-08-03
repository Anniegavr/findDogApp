package com.learn.devme.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public void addNewOwner(Owner owner) {
        Optional<Owner> ownerOptional = ownerRepository.findOwnerByName(owner.getName());
        if (ownerOptional.isPresent()){
            throw new IllegalStateException("name taken");
        }
        ownerRepository.save(owner);
    }

    public void deleteOwner(Long ownerId) {
        boolean exists = ownerRepository.existsById(ownerId);
        if (!exists){
            throw new IllegalStateException("owner with id "+ownerId+" doesn't exist");
        }
        ownerRepository.deleteById(ownerId);
    }

//    @Transactional
    public void updateOwner(Long ownerId, String name, String password) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new IllegalStateException(
                "owner with id "+ownerId+" doesn't exist"));
        if ((name != null) && (name.length() > 0) && !Objects.equals(owner.getName(), name)){
            owner.setName(name);
        }
        if ((password != null) && (password.length() > 0) && !Objects.equals(owner.getPassword(), password)){
            owner.setPassword(password);
        }
    }
}
