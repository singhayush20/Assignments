package com.ayushsingh.ta_candidate.service;

import com.ayushsingh.ta_candidate.model.dto.interviewDtos.InterviewCreateDto;
import com.ayushsingh.ta_candidate.model.dto.interviewDtos.InterviewDetailsDto;
import com.ayushsingh.ta_candidate.model.dto.interviewDtos.InterviewStatusUpdateDto;
import com.ayushsingh.ta_candidate.model.dto.interviewResultDtos.InterviewResultCreateDto;
import com.ayushsingh.ta_candidate.model.projection.interview.InterviewListProjection;

import java.util.List;

public interface InterviewService {

     String scheduleInterview(InterviewCreateDto interviewCreateDto);

     List<InterviewListProjection> getInterviewList(String candidateToken);

     String updateInterviewStatus(InterviewStatusUpdateDto interviewStatusUpdateDto);

     InterviewDetailsDto getInterviewDetails(String interviewToken, String candidateToken);

     String saveInterviewResult(InterviewResultCreateDto interviewResultCreateDto);
}
