package com.learn.devme.registration;

import com.learn.devme.models.Owner;
import com.learn.devme.service.OwnerService;
import lombok.AllArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private EmailValidator emailValidator;
    private final OwnerService ownerService;

    public JSONObject register(RegistrationRequest request){
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }

        return ownerService.signUpOwner(new Owner(request.getFirstName(), request.getEmail(), request.getPassword()));
    }

}
