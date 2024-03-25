package com.ayushsingh.ta_candidate.repository;

import com.ayushsingh.ta_candidate.model.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    @Query("SELECT r FROM Resume r WHERE r.candidate.candidateToken = ?1")
    Optional<Resume> findByCandidateToken(String candidateToken);
}
