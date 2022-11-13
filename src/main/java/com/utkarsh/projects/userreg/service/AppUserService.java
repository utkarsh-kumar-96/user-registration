package com.utkarsh.projects.userreg.service;

import com.utkarsh.projects.userreg.entity.AppUser;

import java.util.List;

public interface AppUserService {
    List<AppUser> findAll();
}
