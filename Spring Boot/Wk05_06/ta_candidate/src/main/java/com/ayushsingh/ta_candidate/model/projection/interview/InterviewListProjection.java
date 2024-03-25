package com.ayushsingh.ta_candidate.model.projection.interview;

import com.ayushsingh.ta_candidate.model.constants.InterviewStatus;

import java.time.ZonedDateTime;

public interface InterviewListProjection {

    Long getInterviewToken();

    Long getInterviewSubject();

    ZonedDateTime getInterviewTime();

    String getInterviewMode();

    InterviewStatus getInterviewStatus();
}
