package org.ayushsingh.jdbc_jpa_demo.controller;

import lombok.RequiredArgsConstructor;
import org.ayushsingh.jdbc_jpa_demo.dto.department.DepartmentCreateDto;
import org.ayushsingh.jdbc_jpa_demo.dto.department.DepartmentDetailsDto;
import org.ayushsingh.jdbc_jpa_demo.service.DepartmentService;

import org.ayushsingh.jdbc_jpa_demo.util.responseUtil.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing department-related operations.
 * REST APIs for department related operations are defined here.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
@RestController
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;


    /**
     * Creates a new department.
     *
     * @param department The DTO representing the department to be created.
     * @return {@link ResponseEntity} containing {@link ApiResponse} with details of the created department.
     */
    @PostMapping(value = "/new")
    public ResponseEntity<ApiResponse<DepartmentDetailsDto>> createDepartment(@RequestBody  DepartmentCreateDto department) {
        DepartmentDetailsDto departmentDetailsDto=departmentService.create(department);
        return new ResponseEntity<>(new ApiResponse<>(departmentDetailsDto), HttpStatus.CREATED);
    }
}
