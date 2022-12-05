package com.utkarsh.projects.userreg.service.Impl;

import com.utkarsh.projects.userreg.entity.AppUser;
import com.utkarsh.projects.userreg.entity.Token;
import com.utkarsh.projects.userreg.repository.TokenRepository;
import com.utkarsh.projects.userreg.service.TokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

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
        regToken.setConfirmed(false);
        regToken.setAppUser(appUser);
        tokenRepository.save(regToken);
    }

    @Override
    public void confirmToken(String token) {
        Token TOKEN = tokenRepository.findByToken(token)
                .orElseThrow(() -> new IllegalArgumentException("token not found with token id " + token));
        TOKEN.setConfirmed(Boolean.TRUE);
        TOKEN.setConfirmedOn(LocalDateTime.now());
        tokenRepository.save(TOKEN);
    }
}