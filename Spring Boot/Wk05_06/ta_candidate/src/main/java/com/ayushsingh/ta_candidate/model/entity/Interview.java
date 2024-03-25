package com.ayushsingh.ta_candidate.model.entity;

import com.ayushsingh.ta_candidate.model.constants.InterviewMode;
import com.ayushsingh.ta_candidate.model.constants.InterviewStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ta_interview")
@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="interview_id")
    private Long interviewId;

    @Column(name = "interview_token",nullable = false,unique = true)
    private String interviewToken;

    @Column(name = "interview_subject",nullable = false,length = 500)
    private String interviewSubject;


    @Column(name = "meet_link",nullable = false,length = 500)
    private String meetLink;

   @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
   @JoinColumn(name="candidate_id",referencedColumnName = "candidate_id")
    private Candidate candidate;

   @OneToOne(mappedBy = "interview",cascade = CascadeType.ALL,orphanRemoval = true)
   private InterviewResult interviewResult;

    @Column(name = "meet_time")
   private ZonedDateTime meetTime;

    @Column(name="interview_status",nullable = false)
    @Enumerated(value=EnumType.STRING)
    private InterviewStatus interviewStatus;

    @Column(name="interview_mode",nullable = false)
    @Enumerated(EnumType.STRING)
    private InterviewMode interviewMode;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    public void generateToken() {
        if (this.interviewToken==null) {
            this.interviewToken= UUID.randomUUID().toString();
        }
    }
}
