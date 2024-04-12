package org.ayushsingh.jdbc_jpa_demo.dto.employee;

import lombok.*;
import org.ayushsingh.jdbc_jpa_demo.dto.department.DepartmentCreateDto;
import org.ayushsingh.jdbc_jpa_demo.dto.project.ProjectCreateDto;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeCreateDto {
    private String name;

    private LocalDate dob;

    private Long salary;

    private Long contact;

    private String email;

    private String address;

    private ProjectCreateDto project;

    private DepartmentCreateDto department;
}
