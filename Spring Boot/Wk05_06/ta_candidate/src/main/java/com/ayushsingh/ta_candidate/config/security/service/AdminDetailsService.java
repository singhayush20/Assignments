package com.ayushsingh.ta_candidate.config.security.service;

import com.ayushsingh.ta_candidate.model.entity.Admin;
import com.ayushsingh.ta_candidate.model.securityModels.entity.SecurityAdmin;
import com.ayushsingh.ta_candidate.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> candidate =adminRepository.findByCandidateEmail(username);

        return candidate.map(SecurityAdmin::new).orElse(null);
    }
}
