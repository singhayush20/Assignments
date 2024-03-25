package com.ayushsingh.ta_candidate.repository;

import com.ayushsingh.ta_candidate.model.roles.CandidateRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CandidateRoleRepository extends JpaRepository<CandidateRole, Long> {

    @Query("""
                   SELECT r FROM CandidateRole r WHERE r.roleName = :roleName
            """)
    Optional<CandidateRole> findByRoleName(String roleName);
}
