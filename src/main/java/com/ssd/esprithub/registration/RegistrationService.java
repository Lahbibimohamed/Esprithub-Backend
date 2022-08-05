package com.ssd.esprithub.registration;

import com.ssd.esprithub.entity.Role;
import com.ssd.esprithub.entity.User;
import com.ssd.esprithub.registration.token.ConfirmationToken;
import com.ssd.esprithub.registration.token.ConfirmationTokenService;
import com.ssd.esprithub.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {
    private  final EmailValidator emailValidator;
    private  final UserService userService;
    public final ConfirmationTokenService confirmationTokenService;
    public String register (RegistrationRequest request){
      boolean isValidEmail=  emailValidator.test(request.getEmail());
      if(!isValidEmail) {
          throw new IllegalStateException("email not valid");
      }
        return  userService.signUpUser(
                new User(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getGender(),
                        request.getAddress(),
                        request.getPhone(),
                        Role.user
                )
        );
    }
    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableAppUser(
                confirmationToken.getUser().getEmail());
        return "confirmed";
    }
}
