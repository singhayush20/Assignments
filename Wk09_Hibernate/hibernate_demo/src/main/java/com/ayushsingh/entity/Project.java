package com.ayushsingh.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hb_demo_Project")
public class Project {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(name = "Title", nullable = false, unique = true)
    private String title;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "Start_Date", nullable = false)
    private LocalDate startDate;

    @Column(name = "End_Date", nullable = false)
    private LocalDate endDate;

    @OneToOne(mappedBy = "project", cascade = { CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.DETACH })
    private Employee employee;


}
