package com.uplifther.upliftherservice.config;

import com.uplifther.upliftherservice.config.util.PassageAuthenticationManager;
import com.uplifther.upliftherservice.config.util.PassageJwtAuthenticationFilter;
import id.passageidentity.passage4j.core.app.Passage;
import id.passageidentity.passage4j.core.app.PassageConfig;
import id.passageidentity.passage4j.core.app.PassageNew;
import id.passageidentity.passage4j.core.exception.PassageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebSecurity
public class PassageSecurityConfig {

    @Value("${passage.app.id}")
    String passageAppID;

    @Value("${passage.api.key}")
    String passageApiKey;

    private static final String[] AUTH_WHITELIST = {
            "/auth/**"
    };

    @Bean
    Passage getPassageObject() throws PassageException {
        PassageConfig passageConfig = new PassageConfig();
        passageConfig.setApiKey(passageApiKey);
        passageConfig.setHeaderAuth(true);
        return new PassageNew(passageAppID, passageConfig);
    }

    @Autowired
    PassageAuthenticationManager authenticationManager;

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(new PassageJwtAuthenticationFilter(authenticationManager, getPassageObject(), objectMapper()),
                        UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/api/login").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
