package com.ssd.esprithub.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping(path = "registration")
@CrossOrigin("*")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
    @GetMapping(path = "confirm")
    public RedirectView confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
