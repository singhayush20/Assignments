package com.ayushsingh.ta_candidate.service;

import org.springframework.web.multipart.MultipartFile;

public interface ResumeService {

    String uploadResume(String candidateToken, MultipartFile resume);
}
