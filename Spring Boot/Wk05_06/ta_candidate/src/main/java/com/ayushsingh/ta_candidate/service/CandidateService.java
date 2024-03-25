package com.ayushsingh.ta_candidate.service;

import com.ayushsingh.ta_candidate.model.dto.candidateDtos.CandidateCreateDto;
import com.ayushsingh.ta_candidate.model.projection.candidate.CandidateDetailsProjection;

public interface CandidateService {

    String createNewCandidate(CandidateCreateDto candidateCreateDto);

    CandidateDetailsProjection getCandidateDetails(String candidateToken);
}
