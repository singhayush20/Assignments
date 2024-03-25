package com.ayushsingh.ta_candidate.model.role_enum;

import lombok.Getter;

@Getter
public enum CandidateRoleEnum {

    ROLE_CANDIDATE("ROLE_CANDIDATE");

    private String value;

    CandidateRoleEnum(String value) {
        this.value = value;
    }

}
