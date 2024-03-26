package com.ayushsingh.ta_candidate.service.serviceImpl;

import com.ayushsingh.ta_candidate.model.constants.InterviewMode;
import com.ayushsingh.ta_candidate.model.constants.InterviewStatus;
import com.ayushsingh.ta_candidate.model.dto.interviewDtos.InterviewCreateDto;
import com.ayushsingh.ta_candidate.model.dto.interviewDtos.InterviewDetailsDto;
import com.ayushsingh.ta_candidate.model.dto.interviewDtos.InterviewStatusUpdateDto;
import com.ayushsingh.ta_candidate.model.dto.interviewResultDtos.InterviewResultCreateDto;
import com.ayushsingh.ta_candidate.model.dto.interviewResultDtos.InterviewResultDto;
import com.ayushsingh.ta_candidate.model.dto.resumeDtos.ResumeDetailsDto;
import com.ayushsingh.ta_candidate.model.entity.Candidate;
import com.ayushsingh.ta_candidate.model.entity.Interview;
import com.ayushsingh.ta_candidate.model.entity.InterviewResult;
import com.ayushsingh.ta_candidate.model.entity.Resume;
import com.ayushsingh.ta_candidate.model.projection.interview.InterviewListProjection;
import com.ayushsingh.ta_candidate.repository.CandidateRepository;
import com.ayushsingh.ta_candidate.repository.InterviewRepository;
import com.ayushsingh.ta_candidate.repository.ResumeRepository;
import com.ayushsingh.ta_candidate.service.InterviewService;
import com.ayushsingh.ta_candidate.util.exceptionUtil.ApiException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewServiceImpl implements InterviewService {

    private final InterviewRepository interviewRepository;
    private final CandidateRepository candidateRepository;
    private final ModelMapper modelMapper;
    private final ResumeRepository resumeRepository;
    @Override
    public String scheduleInterview(InterviewCreateDto interviewCreateDto) {
        Candidate candidate = candidateRepository.findByCandidateToken(interviewCreateDto.getCandidateToken()).orElseThrow(() -> new ApiException("Candidate not found"));
        Interview interview = new Interview();
        interview.setCandidate(candidate);
        interview.setInterviewMode(interviewCreateDto.getInterviewMode());
        interview.setInterviewSubject(interviewCreateDto.getInterviewSubject());
        interview.setInterviewStatus(InterviewStatus.SCHEDULED);
        String meetTime = interviewCreateDto.getDateTime();
        String timeZone = interviewCreateDto.getTimeZone();
        ZoneId zoneId = ZoneId.of(timeZone);
        ZonedDateTime selectedDateTime = LocalDateTime.parse(meetTime).atZone(zoneId);
        interview.setMeetTime(selectedDateTime);
        if (interview.getInterviewMode().equals(InterviewMode.ONLINE)) {
            interview.setMeetLink(interviewCreateDto.getMeetLink());
        }
        interview = interviewRepository.save(interview);
        return interview.getInterviewToken();
    }

    @Override
    public List<InterviewListProjection> getInterviewList(String candidateToken) {
        return interviewRepository.getInterviewList(candidateToken);
    }

    @Override
    public String updateInterviewStatus(InterviewStatusUpdateDto interviewStatusUpdateDto) {
        Interview interview = interviewRepository.findByInterviewToken(interviewStatusUpdateDto.getInterviewToken()).orElseThrow(() -> new ApiException("Interview not found"));
        InterviewStatus newStatus = interviewStatusUpdateDto.getInterviewStatus();
        if (interview.getInterviewStatus().equals(newStatus)) {
            //-if new and old status are same
            throw new ApiException("Interview already " + interviewStatusUpdateDto.getInterviewStatus());
        } else if (interview.getInterviewStatus().equals(InterviewStatus.COMPLETED)) {
            //-if new and old status are not same and interview is already complete
            throw new ApiException("Status of interview cannot be changed as it is already complete");
        }
        interview.setInterviewStatus(newStatus);
        return interviewRepository.save(interview).getInterviewToken();
    }

    @Override
    public InterviewDetailsDto getInterviewDetails(String interviewToken, String candidateToken) {
        Interview interview = interviewRepository.findByInterviewToken(interviewToken).orElseThrow(() -> new ApiException("Interview not found"));
        InterviewDetailsDto interviewDetailsDto = new InterviewDetailsDto();
        interviewDetailsDto.setInterviewToken(interview.getInterviewToken());
        interviewDetailsDto.setInterviewMode(interview.getInterviewMode());
        interviewDetailsDto.setInterviewSubject(interview.getInterviewSubject());
        interviewDetailsDto.setInterviewStatus(interview.getInterviewStatus());
        interviewDetailsDto.setMeetLink(interview.getMeetLink());
        interviewDetailsDto.setMeetTime(interview.getMeetTime());
        InterviewResult interviewResult=interview.getInterviewResult();
        InterviewResultDto interviewResultDto = this.modelMapper.map(interviewResult, InterviewResultDto.class);
        interviewDetailsDto.setInterviewResult(interviewResultDto);

        Resume resume = resumeRepository.findByCandidateToken(candidateToken).orElseThrow(() -> new ApiException("Resume not found"));
        interviewDetailsDto.setResumeDetails(this.modelMapper.map(resume, ResumeDetailsDto.class));

        return interviewDetailsDto;
    }

    @Override
    public String saveInterviewResult(InterviewResultCreateDto interviewResultCreateDto) {
        String interviewToken = interviewResultCreateDto.getInterviewToken();
        Interview interview = interviewRepository.findByInterviewToken(interviewToken).orElseThrow(() -> new ApiException("Interview not found"));
        InterviewResult interviewResult = new InterviewResult();
        interviewResult.setInterview(interview);
        interviewResult.setFeedback(interviewResultCreateDto.getFeedback());
        interviewResult.setDecision(interviewResultCreateDto.getDecision());
        interview.setInterviewResult(interviewResult);
        return interviewRepository.save(interview).getInterviewToken();
    }


}
