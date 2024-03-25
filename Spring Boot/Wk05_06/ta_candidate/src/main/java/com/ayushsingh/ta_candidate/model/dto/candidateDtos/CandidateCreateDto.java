package com.ayushsingh.ta_candidate.model.dto.candidateDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateCreateDto {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
}
