package com.ayushsingh.ta_candidate.service.serviceImpl;

import com.ayushsingh.ta_candidate.model.entity.Resume;
import com.ayushsingh.ta_candidate.repository.CandidateRepository;
import com.ayushsingh.ta_candidate.repository.ResumeRepository;
import com.ayushsingh.ta_candidate.service.ResumeService;
import com.ayushsingh.ta_candidate.util.driveUtil.FileService;
import com.ayushsingh.ta_candidate.util.driveUtil.UploadedFileDto;
import com.ayushsingh.ta_candidate.util.exceptionUtil.ApiException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResumeServiceImpl implements ResumeService {
    private final CandidateRepository candidateRepository;

    private final ResumeRepository resumeRepository;

    private final FileService fileService;


    @Transactional
    @Override
    public String uploadResume(String candidateToken, MultipartFile file) {

        Boolean isCandidatePresent = candidateRepository.existsByCandidateToken(candidateToken);
        if (!isCandidatePresent) {
            throw new ApiException("Candidate not found");
        }
       UploadedFileDto fileDto= fileService.uploadFile(file);

        Resume resume=new Resume();
        resume.setCandidate(candidateRepository.findByCandidateToken(candidateToken).get());
        resume.setFormat(fileDto.getFileExtension());
        resume.setDocumentToken(fileDto.getFileId());
        resume.setDocumentName(fileDto.getFileName());
        resume.setDocumentUrl(fileDto.getFileUrl());
        return resumeRepository.save(resume).getDocumentToken();
    }
}
