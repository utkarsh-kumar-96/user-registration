package com.utkarsh.projects.userreg.service.Impl;

import com.utkarsh.projects.userreg.model.RegistrationRequest;
import com.utkarsh.projects.userreg.service.AppUserService;
import com.utkarsh.projects.userreg.service.RegistrationService;
import com.utkarsh.projects.userreg.util.CommonUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final AppUserService appUserService;

    @Override
    public String register(RegistrationRequest request) {
        if (request.getEmail() == null)
            throw new IllegalArgumentException("email not specified");
        boolean isEmailValid = CommonUtil.validateEmail(request.getEmail());
        return appUserService.signUpUser(request);
    }


}
