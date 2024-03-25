package com.ayushsingh.ta_candidate.service.serviceImpl;

import com.ayushsingh.ta_candidate.model.dto.candidateDtos.CandidateCreateDto;
import com.ayushsingh.ta_candidate.model.entity.Candidate;
import com.ayushsingh.ta_candidate.model.projection.candidate.CandidateDetailsProjection;
import com.ayushsingh.ta_candidate.model.role_enum.CandidateRoleEnum;
import com.ayushsingh.ta_candidate.model.roles.CandidateRole;
import com.ayushsingh.ta_candidate.repository.CandidateRepository;
import com.ayushsingh.ta_candidate.service.CandidateRoleService;
import com.ayushsingh.ta_candidate.service.CandidateService;
import com.ayushsingh.ta_candidate.util.exceptionUtil.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final PasswordEncoder passwordEncoder;
    private final CandidateRoleService candidateRoleService;

    @Override
    public String createNewCandidate(CandidateCreateDto candidateCreateDto) {
        Boolean isCandidatePresent = candidateRepository.existsByEmail(candidateCreateDto.getEmail());
        if (isCandidatePresent) {
            throw new ApiException("Email already exists");
        }
        Candidate candidate = new Candidate();
        candidate.setEmail(candidateCreateDto.getEmail());
        candidate.setFirstName(candidateCreateDto.getFirstName());
        candidate.setLastName(candidateCreateDto.getLastName());
        candidate.setPassword(passwordEncoder.encode(candidateCreateDto.getPassword()));
        CandidateRole candidateRole=candidateRoleService.getCandidateRoleByRoleName(CandidateRoleEnum.ROLE_CANDIDATE.getValue());
        HashSet<CandidateRole> roles=new HashSet<>();
        roles.add(candidateRole);
        candidate.setRoles(roles);
        return candidateRepository.save(candidate).getCandidateToken();
    }

    @Override
    public CandidateDetailsProjection getCandidateDetails(String candidateEmail) {
        Optional<CandidateDetailsProjection> candidateDetailsProjection = candidateRepository.findDetailsByCandidateEmail(candidateEmail);
        if (candidateDetailsProjection.isEmpty()) {
            throw new ApiException("Candidate not found");
        }
        return candidateDetailsProjection.get();
    }
}
