package com.utkarsh.projects.userreg.service.Impl;

import com.utkarsh.projects.userreg.entity.AppUser;
import com.utkarsh.projects.userreg.entity.Token;
import com.utkarsh.projects.userreg.repository.TokenRepository;
import com.utkarsh.projects.userreg.service.TokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class TokenServiceImpl implements TokenService {
    private final TokenRepository tokenRepository;
    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void saveToken(String token, AppUser appUser) {
        Token regToken = new Token();
        LocalDateTime now = LocalDateTime.now();
        regToken.setToken(token);
        regToken.setCreatedOn(now);
        regToken.setExpiredOn(now.plus(15, ChronoUnit.MINUTES));
        regToken.setAppUser(appUser);
        regToken.setConfirmed(Boolean.TRUE);
        regToken.setConfirmedOn(now);
        tokenRepository.save(regToken);
    }
}