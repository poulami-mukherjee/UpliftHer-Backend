package com.uplifther.upliftherservice.config.util;

import java.util.Collections;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@Configuration
public class PassageAuthenticationManager implements AuthenticationManager{
    @Override
    public Authentication authenticate(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        return
                new UsernamePasswordAuthenticationToken(
                        principal, authentication.getCredentials(), Collections.emptyList());
    }
}
