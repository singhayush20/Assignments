package com.ayushsingh.ta_candidate.config.security.authProvider;

import com.ayushsingh.ta_candidate.config.security.service.AdminDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AdminAuthProvider implements AuthenticationProvider {

    private final AdminDetailsService adminDetailsService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = String.valueOf(authentication.getPrincipal());
        String password = String.valueOf(authentication.getCredentials());

        UserDetails candidateDetails = adminDetailsService.loadUserByUsername(username);
        if (candidateDetails != null) {
            if (passwordEncoder.matches(password, candidateDetails.getPassword())) {

                return new UsernamePasswordAuthenticationToken(username, password, candidateDetails.getAuthorities());

            }
        }
        throw new BadCredentialsException("Wrong Credentials");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
