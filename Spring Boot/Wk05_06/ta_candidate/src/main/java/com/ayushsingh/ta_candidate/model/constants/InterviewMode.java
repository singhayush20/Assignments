package com.ayushsingh.ta_candidate.model.constants;

import lombok.Getter;

import java.util.EnumSet;
import java.util.Set;

@Getter
public enum InterviewMode {

    OFFLINE("OFFLINE"), ONLINE("ONLINE");

    private final String value;

    InterviewMode(String value) {
        this.value = value;
    }

    public Set<InterviewMode> getInterviewModes() {
        return EnumSet.allOf(InterviewMode.class);
    }
}
