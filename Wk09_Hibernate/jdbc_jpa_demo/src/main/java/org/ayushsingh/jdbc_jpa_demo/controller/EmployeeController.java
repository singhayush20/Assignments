package org.ayushsingh.jdbc_jpa_demo.controller;

import lombok.RequiredArgsConstructor;
import org.ayushsingh.jdbc_jpa_demo.dto.employee.EmployeeCreateDto;
import org.ayushsingh.jdbc_jpa_demo.dto.employee.EmployeeDetailsDto;
import org.ayushsingh.jdbc_jpa_demo.dto.project.ProjectCreateDto;
import org.ayushsingh.jdbc_jpa_demo.dto.project.ProjectDetailsDto;
import org.ayushsingh.jdbc_jpa_demo.service.EmployeeService;
import org.ayushsingh.jdbc_jpa_demo.util.responseUtil.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing employee-related operations.
 * REST APIs for employee related operations are defined here.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    /**
     * Creates a new employee.
     *
     * @param employee The DTO representing the employee to be created.
     * @return {@link ResponseEntity} containing {@link ApiResponse} with details of the created employee.
     */
    @PostMapping("/new")
    public ResponseEntity<ApiResponse<EmployeeDetailsDto>> createEmployee(@RequestBody EmployeeCreateDto employee) {
        EmployeeDetailsDto createdEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(new ApiResponse<>(createdEmployee), HttpStatus.CREATED);
    }


    /**
     * Deletes an employee by ID.
     *
     * @param employeeId The ID of the employee to be deleted.
     * @return {@link ResponseEntity} containing {@link ApiResponse} indicating the success of the operation.
     */
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<ApiResponse<String>> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(new ApiResponse<>("Employee deleted successfully"), HttpStatus.OK);
    }


    /**
     * Assigns a department to an employee.
     *
     * @param employeeId   The ID of the employee.
     * @param departmentId The ID of the department to be assigned.
     * @return {@link ResponseEntity} containing {@link ApiResponse} indicating the success of the operation.
     */
    @PutMapping("/{employeeId}/department/{departmentId}")
    public ResponseEntity<ApiResponse<String>> assignDepartment(@PathVariable Long employeeId,
                                                 @PathVariable Long departmentId) {
        employeeService.assignDepartment(employeeId, departmentId);
        return new ResponseEntity<>(new ApiResponse<>("Department assigned successfully"), HttpStatus.OK);
    }

    /**
     * Creates a new project for an employee.
     *
     * @param employeeId The ID of the employee.
     * @param project    The DTO representing the project to be created.
     * @return {@link ResponseEntity} containing {@link ApiResponse} indicating the success of the operation.
     */
    @PostMapping("/project/new/{employeeId}")
    public ResponseEntity<ProjectDetailsDto> createProjectForEmployee(@PathVariable Long employeeId,
                                                                      @RequestBody ProjectCreateDto project) {
        ProjectDetailsDto createdProject = employeeService.createProjectForEmployee(employeeId, project);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    /**
     * Updates a project for an employee.
     *
     * @param employeeId The ID of the employee.
     * @param project    The DTO representing the updated project details.
     * @return {@link ResponseEntity} containing {@link ApiResponse} indicating the success of the operation.
     */
    @PutMapping("/project/{employeeId}")
    public ResponseEntity<ProjectDetailsDto> updateProjectForEmployee(@PathVariable Long employeeId, @RequestBody ProjectDetailsDto project) {
        ProjectDetailsDto updatedProject = employeeService.updateProjectForEmployee(employeeId, project);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }
}
