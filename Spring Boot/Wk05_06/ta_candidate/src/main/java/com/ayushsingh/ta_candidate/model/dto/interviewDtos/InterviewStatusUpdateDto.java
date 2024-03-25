package com.ayushsingh.ta_candidate.model.dto.interviewDtos;

import com.ayushsingh.ta_candidate.model.constants.InterviewStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterviewStatusUpdateDto {

    private String interviewToken;
    private InterviewStatus interviewStatus;
}
