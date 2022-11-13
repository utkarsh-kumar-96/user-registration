package com.utkarsh.projects.userreg.controller;

import com.utkarsh.projects.userreg.model.RegistrationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return "registration successful";
    }
}
