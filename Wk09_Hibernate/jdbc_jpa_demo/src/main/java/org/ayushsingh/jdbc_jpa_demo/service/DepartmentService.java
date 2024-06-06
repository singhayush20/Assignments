package org.ayushsingh.jdbc_jpa_demo.service;

import org.ayushsingh.jdbc_jpa_demo.dto.department.DepartmentCreateDto;
import org.ayushsingh.jdbc_jpa_demo.dto.department.DepartmentDetailsDto;


/**
 * Service interface for managing {@link org.ayushsingh.jdbc_jpa_demo.entity.Department}-related operations.
 * Defines a method for creating departments.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
public interface DepartmentService {
    DepartmentDetailsDto create(DepartmentCreateDto department);
}
