package com.ayushsingh.ta_candidate.model.securityModels.authority;

import com.ayushsingh.ta_candidate.model.roles.CandidateRole;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class CandidateAuthority implements GrantedAuthority {

    private final CandidateRole candidateRole;

    @Override
    public String getAuthority() {
        return this.candidateRole.getRoleName();
    }

}
