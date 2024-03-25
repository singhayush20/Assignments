package com.ayushsingh.ta_candidate.model.securityModels.authority;

import com.ayushsingh.ta_candidate.model.roles.AdminRole;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class AdminAuthority implements GrantedAuthority {
    private final AdminRole adminRole;

    @Override
    public String getAuthority() {
        return this.adminRole.getRoleName();
    }
}
