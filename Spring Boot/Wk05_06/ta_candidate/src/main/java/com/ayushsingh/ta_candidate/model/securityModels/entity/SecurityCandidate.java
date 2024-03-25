package com.ayushsingh.ta_candidate.model.securityModels.entity;


import com.ayushsingh.ta_candidate.model.entity.Candidate;
import com.ayushsingh.ta_candidate.model.roles.CandidateRole;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SecurityCandidate implements UserDetails {
    private final Candidate candidate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return candidate.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.candidate.getPassword();
    }

    @Override
    public String getUsername() {
        return this.candidate.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
