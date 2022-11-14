package com.utkarsh.projects.userreg.service;

import com.utkarsh.projects.userreg.entity.AppUser;

public interface TokenService {
    void saveToken(String token, AppUser appUser);
}
