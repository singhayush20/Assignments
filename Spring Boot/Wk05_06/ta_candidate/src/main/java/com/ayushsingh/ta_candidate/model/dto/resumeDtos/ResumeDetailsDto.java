package com.ayushsingh.ta_candidate.model.dto.resumeDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDetailsDto {

    private String documentToken;
    private String documentName;
    private String format;
    private String documentUrl;
}
