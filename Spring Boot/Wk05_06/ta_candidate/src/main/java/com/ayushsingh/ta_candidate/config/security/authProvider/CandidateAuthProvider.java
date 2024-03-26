    package com.ayushsingh.ta_candidate.config.security.authProvider;

    import com.ayushsingh.ta_candidate.config.security.service.CandidateDetailsService;
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
    public class CandidateAuthProvider implements AuthenticationProvider {

        private final CandidateDetailsService candidateDetailsService;
        private final PasswordEncoder passwordEncoder;
        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            String username = String.valueOf(authentication.getPrincipal());
            String password=String.valueOf(authentication.getCredentials());

            UserDetails candidateDetails = candidateDetailsService.loadUserByUsername(username);
            if(candidateDetails!=null){
                if(passwordEncoder.matches(password,candidateDetails.getPassword())){

                        return new UsernamePasswordAuthenticationToken(username,password,candidateDetails.getAuthorities());

                }
            }
            throw new BadCredentialsException("Wrong Credentials");
        }

        @Override
        public boolean supports(Class<?> authentication) {
            return UsernamePasswordAuthenticationToken.class.equals(authentication);
        }
    }
