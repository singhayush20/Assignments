package com.ayushsingh.ta_candidate.model.entity;

import com.ayushsingh.ta_candidate.model.roles.CandidateRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ta_candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private Long candidateId;

    @Column(name="candidate_token",nullable = false,unique = true)
    private String candidateToken;

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @OneToOne(mappedBy = "candidate",cascade = CascadeType.ALL,orphanRemoval = true)
    private Resume resume;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ta_candidate_candidate_role", joinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "candidate_id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<CandidateRole> roles;

    @OneToMany(mappedBy = "candidate",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private Set<Interview> interviews=new HashSet<>();

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
        if (this.candidateToken==null) {
            this.candidateToken=UUID.randomUUID().toString();
        }
    }
}
