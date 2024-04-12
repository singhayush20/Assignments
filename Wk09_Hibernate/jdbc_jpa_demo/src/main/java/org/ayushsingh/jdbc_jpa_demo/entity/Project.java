package org.ayushsingh.jdbc_jpa_demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


/**
 * Entity class representing a project.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
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

    @OneToOne(mappedBy = "project", cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    private Employee employee;


}
