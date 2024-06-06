package org.ayushsingh.jdbc_jpa_demo.service;


import org.ayushsingh.jdbc_jpa_demo.dto.employee.EmployeeCreateDto;
import org.ayushsingh.jdbc_jpa_demo.dto.employee.EmployeeDetailsDto;
import org.ayushsingh.jdbc_jpa_demo.dto.project.ProjectCreateDto;
import org.ayushsingh.jdbc_jpa_demo.dto.project.ProjectDetailsDto;

/**
 * Service interface for managing {@link org.ayushsingh.jdbc_jpa_demo.entity.Employee}-related operations.
 * Defines methods for creating, deleting, and updating employees, as well as assigning departments and projects.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
public interface EmployeeService {
    EmployeeDetailsDto createEmployee(EmployeeCreateDto employee);

    void deleteEmployee(Long employeeId);

    void assignDepartment(Long employeeId, Long departmentId);

    ProjectDetailsDto createProjectForEmployee(Long employeeId, ProjectCreateDto project);

    ProjectDetailsDto updateProjectForEmployee(Long employeeId, ProjectDetailsDto project);

}
