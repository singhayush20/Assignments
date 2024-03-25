package com.ayushsingh.ta_candidate.controller;


import com.ayushsingh.ta_candidate.config.security.util.JwtUtil;
import com.ayushsingh.ta_candidate.constants.AppConstants;
import com.ayushsingh.ta_candidate.model.dto.authDtos.LoginResponseDto;
import com.ayushsingh.ta_candidate.model.dto.candidateDtos.CandidateCreateDto;
import com.ayushsingh.ta_candidate.model.projection.candidate.CandidateDetailsProjection;
import com.ayushsingh.ta_candidate.service.CandidateService;
import com.ayushsingh.ta_candidate.service.ResumeService;
import com.ayushsingh.ta_candidate.util.exceptionUtil.ApiException;
import com.ayushsingh.ta_candidate.util.responseUtil.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/candidate")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;
    private final ResumeService resumeService;

    @PostMapping("/new")
    public ResponseEntity<ApiResponse<String>> newCandidate(@RequestBody CandidateCreateDto candidateCreateDto) {
        String token = candidateService.createNewCandidate(candidateCreateDto);
        return new ResponseEntity<>(new ApiResponse<>(token), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDto>> login() {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String accessToken = JwtUtil.generateToken(username, AppConstants.ENTITY_TYPE_CANDIDATE);
            LoginResponseDto loginResponseDto = new LoginResponseDto();
            loginResponseDto.setAccessToken(accessToken);
            loginResponseDto.setUsername(username);
            return new ResponseEntity<>(new ApiResponse<>(loginResponseDto), HttpStatus.OK);

        }
        throw new ApiException("User authentication failed!");
    }

    @GetMapping("/details")
    public ResponseEntity<ApiResponse<CandidateDetailsProjection>> candidateDetails(@RequestParam(value = "candidateEmail") String candidateEmail) {
        return new ResponseEntity<>(new ApiResponse<>(candidateService.getCandidateDetails(candidateEmail)), HttpStatus.OK);
    }

    @PostMapping("/resume/upload")
    public ResponseEntity<ApiResponse<String>> uploadFile(@RequestParam("candidateToken") String candidateToken, @RequestPart("file") MultipartFile multipartFile) {
        return new ResponseEntity<>(new ApiResponse<>(resumeService.uploadResume(candidateToken, multipartFile)), HttpStatus.CREATED);
    }
}
