package com.utkarsh.projects.userreg.controller;

import com.utkarsh.projects.userreg.model.RegistrationRequest;
import com.utkarsh.projects.userreg.service.RegistrationService;
import com.utkarsh.projects.userreg.service.TokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    private final RegistrationService registrationService;
    private final TokenService tokenService;

    public RegistrationController(RegistrationService registrationService, TokenService tokenService) {
        this.registrationService = registrationService;
        this.tokenService = tokenService;
    }

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        registrationService.register(request);
        return "registration successful";
    }

    @GetMapping("/confirm")
    public String confirm(@RequestParam("token") String token) {
        tokenService.confirmToken(token);
        return "confirmed";
    }
}
