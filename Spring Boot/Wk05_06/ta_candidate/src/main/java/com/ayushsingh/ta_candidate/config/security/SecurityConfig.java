package com.ayushsingh.ta_candidate.config.security;

import com.ayushsingh.ta_candidate.config.security.authProvider.AdminAuthProvider;
import com.ayushsingh.ta_candidate.config.security.authProvider.CandidateAuthProvider;
import com.ayushsingh.ta_candidate.constants.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    private final AuthenticationEntryPoint authEntryPoint;
    private final CandidateAuthProvider candidateAuthProvider;
    private final AdminAuthProvider adminAuthProvider;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;


    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(candidateAuthProvider).authenticationProvider(adminAuthProvider);

        return authenticationManagerBuilder.build();
    }


    @Bean
    public CustomAuthFilter customAuthenticationFilter(HttpSecurity http) throws Exception {
        return new CustomAuthFilter(authManager(http));
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.cors().configurationSource(request -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(List.of("*"));
            configuration.setAllowedMethods(List.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
            configuration.setAllowCredentials(true);
            configuration.addExposedHeader("Message");
            configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
            return configuration;
        })
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(AppConstants.PUBLIC_URLS).permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(customAuthenticationFilter(http), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
