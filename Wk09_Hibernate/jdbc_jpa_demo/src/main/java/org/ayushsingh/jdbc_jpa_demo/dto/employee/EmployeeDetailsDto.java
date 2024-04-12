package org.ayushsingh.jdbc_jpa_demo.dto.employee;


import lombok.*;
import org.ayushsingh.jdbc_jpa_demo.dto.department.DepartmentDetailsDto;
import org.ayushsingh.jdbc_jpa_demo.dto.project.ProjectDetailsDto;

import java.time.LocalDate;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDetailsDto {

    private Long employeeId;
    private String name;

    private LocalDate dob;

    private Long salary;

    private Long contact;

    private String email;

    private String address;

    private ProjectDetailsDto project;
    private DepartmentDetailsDto department;
}

