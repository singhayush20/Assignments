package com.ayushsingh.ta_candidate.model.dto.interviewDtos;

import com.ayushsingh.ta_candidate.model.constants.InterviewMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterviewCreateDto {

    private String interviewSubject;

    private String candidateToken;

    private String dateTime;

    private String meetLink;

    private String timeZone;

    private InterviewMode interviewMode;
}
