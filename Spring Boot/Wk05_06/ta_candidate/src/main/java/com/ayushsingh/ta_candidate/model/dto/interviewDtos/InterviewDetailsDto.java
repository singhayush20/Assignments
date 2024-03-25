package com.ayushsingh.ta_candidate.model.dto.interviewDtos;

import com.ayushsingh.ta_candidate.model.constants.InterviewMode;
import com.ayushsingh.ta_candidate.model.constants.InterviewStatus;
import com.ayushsingh.ta_candidate.model.dto.interviewResultDtos.InterviewResultDto;
import com.ayushsingh.ta_candidate.model.dto.resumeDtos.ResumeDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterviewDetailsDto {

    private String interviewSubject;

    private String meetLink;

    private ZonedDateTime meetTime;

    private InterviewResultDto interviewResult;

    private ResumeDetailsDto resumeDetails;

    private InterviewMode interviewMode;

    private InterviewStatus interviewStatus;

    private String interviewToken;

}
