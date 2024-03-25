package com.ayushsingh.ta_candidate.repository;

import com.ayushsingh.ta_candidate.model.entity.Interview;
import com.ayushsingh.ta_candidate.model.projection.interview.InterviewListProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

    @Query("""
            select
            i.interviewSubject as interviewSubject,
            i.interviewMode as interviewMode,
            i.interviewStatus as interviewStatus,
            i.meetTime as interviewTime,
            i.interviewToken as interviewToken
            from Interview i where i.candidate.candidateToken = :candidateToken
            """)
    List<InterviewListProjection> getInterviewList(String candidateToken);

    @Query("select i from Interview i where i.interviewToken = :interviewToken")
    Optional<Interview>  findByInterviewToken(String interviewToken);
}