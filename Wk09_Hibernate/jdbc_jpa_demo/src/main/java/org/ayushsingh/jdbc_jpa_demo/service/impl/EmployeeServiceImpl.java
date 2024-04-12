package org.ayushsingh.jdbc_jpa_demo.service.impl;


import lombok.RequiredArgsConstructor;
import org.ayushsingh.jdbc_jpa_demo.dao.EmployeeDao;
import org.ayushsingh.jdbc_jpa_demo.dto.employee.EmployeeCreateDto;
import org.ayushsingh.jdbc_jpa_demo.dto.employee.EmployeeDetailsDto;
import org.ayushsingh.jdbc_jpa_demo.dto.project.ProjectCreateDto;
import org.ayushsingh.jdbc_jpa_demo.dto.project.ProjectDetailsDto;
import org.ayushsingh.jdbc_jpa_demo.entity.Department;
import org.ayushsingh.jdbc_jpa_demo.entity.Employee;
import org.ayushsingh.jdbc_jpa_demo.entity.Project;
import org.ayushsingh.jdbc_jpa_demo.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



/**
 * Service implementation for managing employee-related operations.
 * Implements methods for creating, deleting, and updating employees,
 * as well as assigning departments and projects.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final Logger logger= LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeDao employeeDao;
    private final ModelMapper modelMapper;


    /**
     * Creates a new employee.
     *
     * @param employee The DTO representing the employee to be created.
     * @return The details as {@link EmployeeDetailsDto} for the created employee.
     */
    @Override
    public EmployeeDetailsDto createEmployee(EmployeeCreateDto employee) {
        Employee emp=new Employee();
        emp.setName(employee.getName());
        emp.setDob(employee.getDob());
        emp.setContact(employee.getContact());
        emp.setEmail(employee.getEmail());
        emp.setAddress(employee.getAddress());
        emp.setSalary(employee.getSalary());
        Project project=this.modelMapper.map(employee.getProject(),Project.class);
        project.setEmployee(emp);
        emp.setProject(project);
        Department department=this.modelMapper.map(employee.getDepartment(),Department.class);
        emp.setDepartment(department);
        emp=employeeDao.save(emp);
        return this.modelMapper.map(emp,EmployeeDetailsDto.class);
    }

    /**
     * Deletes an employee by ID.
     *
     * @param employeeId The ID of the employee to be deleted.
     */
    @Override
    public void deleteEmployee(Long employeeId) {
        logger.info("deleting employee with id {}",employeeId);
        employeeDao.delete(employeeId);
        logger.info("deleted employee with id {}",employeeId);
    }


    /**
     * Updates a project for an employee.
     *
     * @param employeeId The ID of the employee.
     * @param prj    The DTO representing the updated project details.
     * @return The details as {@link ProjectDetailsDto} for the updated project.
     */

    @Override
    public ProjectDetailsDto updateProjectForEmployee(Long employeeId, ProjectDetailsDto prj) {
        logger.info("updating project for employee with id {} project: {}",employeeId,prj);
        Project project=this.modelMapper.map(prj,Project.class);
        Project updatedProject=employeeDao.updateProjectForEmployee(employeeId,project);
        logger.info("updated project for employee with id {} project: {}",employeeId,updatedProject);
        return this.modelMapper.map(updatedProject,ProjectDetailsDto.class);
    }


    /**
     * Assigns a department to an employee.
     *
     * @param employeeId   The ID of the employee.
     * @param departmentId The ID of the department to be assigned.
     */
    @Override
    public void assignDepartment(Long employeeId, Long departmentId) {
        logger.info("assigning department to employee with id {} department: {}",employeeId,departmentId);
        this.employeeDao.assignDepartment(employeeId,departmentId);
        logger.info("assigned department to employee with id {} ",employeeId);
    }


    /**
     * Creates a new project for an employee.
     *
     * @param employeeId The ID of the employee.
     * @param newProject    The DTO representing the project to be created.
     * @return The details as {@link ProjectDetailsDto} of the created project.
     */
    @Override
    public ProjectDetailsDto createProjectForEmployee(Long employeeId, ProjectCreateDto newProject) {
        logger.info("creating project for employee with id {} project: {}",employeeId,newProject);
        Project project=this.modelMapper.map(newProject,Project.class);
        project=employeeDao.assignNewProject(employeeId,project);
        logger.info("created project for employee with id {} project: {}",employeeId,project);
        return this.modelMapper.map(project,ProjectDetailsDto.class);
    }

}
