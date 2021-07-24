package com.learn.devme.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/owner")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService){

        this.ownerService = ownerService;
    }
    @GetMapping
    public List<Owner> getAllUsers() {
        return ownerService.getAllOwners();
    }

    @PostMapping
    public void registerOwner(@RequestBody Owner owner){
        ownerService.addNewOwner(owner);
    }

    @DeleteMapping(path = "{ownerId}")
    public void deleteOwner(@PathVariable("ownerId") Long ownerId){
        ownerService.deleteOwner(ownerId);
    }

    @PutMapping(path = "{ownerId}")
    public void updateOwner(@PathVariable("ownerId") Long ownerId,
                            @RequestParam(required = false) String name,
                            @RequestBody(required = false) String password){
        ownerService.updateOwner(ownerId, name, password);
    }
}
