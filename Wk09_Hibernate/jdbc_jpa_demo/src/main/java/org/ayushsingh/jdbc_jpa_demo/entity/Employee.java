package org.ayushsingh.jdbc_jpa_demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Entity class representing an employee.
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
@Table(name = "hb_demo_Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long employeeId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "DOB", nullable = false)
    private LocalDate dob;

    @Column(name = "Salary", nullable = false)
    private Long salary;

    @Column(name = "Contact", nullable = false, unique = true, length = 10)
    private Long contact;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Address", nullable = false)
    private String address;

    @OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "Project_ID", referencedColumnName = "ID")
    private Project project;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name="Department_ID", referencedColumnName = "ID")
    private Department department;
}

