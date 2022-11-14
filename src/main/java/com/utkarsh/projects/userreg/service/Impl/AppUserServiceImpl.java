package com.utkarsh.projects.userreg.service.Impl;

import com.utkarsh.projects.userreg.entity.AppUser;
import com.utkarsh.projects.userreg.model.RegistrationRequest;
import com.utkarsh.projects.userreg.repository.AppUserRepository;
import com.utkarsh.projects.userreg.service.AppUserService;
import com.utkarsh.projects.userreg.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserServiceImpl implements UserDetailsService, AppUserService {
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenService tokenService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found with username " + username));
        return appUser;
    }
    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }
    @Override
    public String signUpUser(RegistrationRequest request) {
        Optional<AppUser> optionalAppUser = appUserRepository.findByEmail(request.getEmail());
        if (optionalAppUser.isPresent())
            throw new IllegalStateException("user with email " + request.getEmail() + " already present");
        AppUser appUser = mapRegistrationReqToAppUser(request);
        AppUser savedUser = appUserRepository.save(appUser);
        String token = UUID.randomUUID().toString();
        tokenService.saveToken(token, savedUser);
        return "";
    }

    @Override
    public AppUser mapRegistrationReqToAppUser(RegistrationRequest request) {
        AppUser appUser = new AppUser();
        appUser.setEmail(request.getEmail());
        appUser.setFirstName(request.getFirstName());
        appUser.setLastName(request.getLastName());
        String encodedPass = bCryptPasswordEncoder.encode(request.getPassword());
        appUser.setPassword(encodedPass);
        return null;
    }
}