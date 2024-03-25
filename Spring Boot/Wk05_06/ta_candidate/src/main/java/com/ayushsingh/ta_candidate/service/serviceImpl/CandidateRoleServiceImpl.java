package com.ayushsingh.ta_candidate.service.serviceImpl;

import com.ayushsingh.ta_candidate.model.roles.CandidateRole;
import com.ayushsingh.ta_candidate.repository.CandidateRoleRepository;
import com.ayushsingh.ta_candidate.service.CandidateRoleService;
import com.ayushsingh.ta_candidate.util.exceptionUtil.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidateRoleServiceImpl implements CandidateRoleService {

    private final CandidateRoleRepository candidateRoleRepository;
    @Override
    public CandidateRole getCandidateRoleByRoleName(String roleName) {
        Optional<CandidateRole> userRole=candidateRoleRepository.findByRoleName(roleName);
        if(userRole.isPresent()){
            return userRole.get();
        }
        else{
            throw new ApiException("Candidate role with name: "+roleName+" does not exist");
        }
    }
}
