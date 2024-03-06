package com.tutorial.Shoppy.registration;

import com.tutorial.Shoppy.appuser.AppUser;
import com.tutorial.Shoppy.appuser.AppUserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.tutorial.Shoppy.appuser.AppUserServices;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserServices appUserServices;
    private final EmailValidator emailValidator;
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return appUserServices.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
