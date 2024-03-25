package com.ayushsingh.ta_candidate.controller;

import com.ayushsingh.ta_candidate.model.dto.interviewDtos.InterviewCreateDto;
import com.ayushsingh.ta_candidate.model.dto.interviewDtos.InterviewDetailsDto;
import com.ayushsingh.ta_candidate.model.dto.interviewDtos.InterviewStatusUpdateDto;
import com.ayushsingh.ta_candidate.model.dto.interviewResultDtos.InterviewResultCreateDto;
import com.ayushsingh.ta_candidate.model.projection.interview.InterviewListProjection;
import com.ayushsingh.ta_candidate.service.InterviewService;
import com.ayushsingh.ta_candidate.util.responseUtil.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/interview")
@RequiredArgsConstructor
public class InterviewController {

    private final InterviewService interviewService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<String>> scheduleInterview(@RequestBody InterviewCreateDto interviewCreateDto) {
        String interviewToken= interviewService.scheduleInterview(interviewCreateDto);
        return new ResponseEntity<>(new ApiResponse<>(interviewToken), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<InterviewListProjection>>> getInterviewListForCandidate(@RequestParam(value = "token") String token) {
        return new ResponseEntity<>(new ApiResponse<>(interviewService.getInterviewList(token)), HttpStatus.OK);
    }

    @PatchMapping("/status")
    public ResponseEntity<ApiResponse<String>> updateInterviewStatus(@RequestBody InterviewStatusUpdateDto interviewStatusUpdateDto){
        return new ResponseEntity<>(new ApiResponse<>(interviewService.updateInterviewStatus(interviewStatusUpdateDto)), HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<ApiResponse<InterviewDetailsDto>> getInterviewDetails(@RequestParam("interviewToken") String interviewToken, @RequestParam("candidateToken") String candidateToken){
        return new ResponseEntity<>(new ApiResponse<>(interviewService.getInterviewDetails(interviewToken, candidateToken)), HttpStatus.OK);
    }

    @PostMapping("/feedback")
    public ResponseEntity<ApiResponse<String>> updateFeedback(@RequestBody InterviewResultCreateDto interviewResultDto){
        return new ResponseEntity<>(new ApiResponse<>(interviewService.saveInterviewResult(interviewResultDto)), HttpStatus.CREATED);
    }
}
