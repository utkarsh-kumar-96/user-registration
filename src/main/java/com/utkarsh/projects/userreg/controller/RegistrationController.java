package com.utkarsh.projects.userreg.controller;

import com.utkarsh.projects.userreg.model.RegistrationRequest;
import com.utkarsh.projects.userreg.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        registrationService.register(request);
        return "registration successful";
    }

    @GetMapping("/confirm")
    public String confirm(@RequestParam("token") String token) {

        return "confirmed";
    }
}
