package com.utkarsh.projects.userreg.service;

import com.utkarsh.projects.userreg.entity.AppUser;
import com.utkarsh.projects.userreg.model.RegistrationRequest;

import java.util.List;

public interface AppUserService {
    List<AppUser> findAll();
    String signUpUser(RegistrationRequest request);
    AppUser mapRegistrationReqToAppUser(RegistrationRequest request);
}
