package com.ayushsingh.ta_candidate.model.dto.interviewResultDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterviewResultDto {

    private String interviewResultToken;

    private String feedback;

    private String decision;

}
