package com.ayushsingh.ta_candidate.config.security.service;


import com.ayushsingh.ta_candidate.model.entity.Candidate;
import com.ayushsingh.ta_candidate.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsumerDetailsService implements UserDetailsService {


    private final CandidateRepository candidateRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Candidate> candidate = candidateRepository.findByCandidateEmail(username);

        return user.map(SecurityConsumer::new).orElse(null);
    }
}
