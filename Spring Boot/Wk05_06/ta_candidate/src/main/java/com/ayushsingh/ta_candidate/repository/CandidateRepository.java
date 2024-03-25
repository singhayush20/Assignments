package com.ayushsingh.ta_candidate.repository;

import com.ayushsingh.ta_candidate.model.entity.Candidate;
import com.ayushsingh.ta_candidate.model.projection.candidate.CandidateDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {


    @Query("select c from Candidate c where c.candidateToken = ?1")
    Optional<Candidate> findByCandidateToken(String token);

    @Query("select c from Candidate c where c.email = ?1")
    Optional<Candidate> findByCandidateEmail(String email);

    Boolean existsByEmail(String email);

    @Query("""
            select
            c.email as email,
            c.candidateToken as token,
            c.firstName as firstName,
            c.lastName as lastName,
            c.resume.documentUrl as resumeUrl,
            c.resume.documentToken as documentToken
            from Candidate c
            where c.email = ?1
            """)
    Optional<CandidateDetailsProjection> findDetailsByCandidateEmail(String candidateEmail);


    Boolean existsByCandidateToken(String candidateToken);
}