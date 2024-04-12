package org.ayushsingh.jdbc_jpa_demo.service.impl;


import lombok.RequiredArgsConstructor;
import org.ayushsingh.jdbc_jpa_demo.dao.DepartmentDao;
import org.ayushsingh.jdbc_jpa_demo.dto.department.DepartmentCreateDto;
import org.ayushsingh.jdbc_jpa_demo.dto.department.DepartmentDetailsDto;
import org.ayushsingh.jdbc_jpa_demo.entity.Department;
import org.ayushsingh.jdbc_jpa_demo.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * Service implementation for managing department-related operations.
 * Implements method for creating departments.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao;
    private final ModelMapper modelMapper;

    /**
     * Creates a new department.
     *
     * @param departmentDto The DTO representing the department to be created.
     * @return The details as {@link DepartmentDetailsDto} for the created department.
     */
    @Override
    public DepartmentDetailsDto create(DepartmentCreateDto departmentDto) {
        Department department=this.modelMapper.map(departmentDto,Department.class);
        department=this.departmentDao.create(department);
        return this.modelMapper.map(department,DepartmentDetailsDto.class);
    }
}
