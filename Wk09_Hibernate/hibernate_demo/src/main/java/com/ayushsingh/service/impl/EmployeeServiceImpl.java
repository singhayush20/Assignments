package com.ayushsingh.service.impl;

import com.ayushsingh.dao.EmployeeDao;
import com.ayushsingh.entity.Department;
import com.ayushsingh.entity.Employee;
import com.ayushsingh.entity.Project;
import com.ayushsingh.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class EmployeeServiceImpl implements EmployeeService {

    private final Logger logger= LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    @Override
    public Employee createEmployee(Employee employee) {
        logger.debug("creating employee {}",employee);
        return employeeDao.save(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        logger.info("deleting employee with id {}",employeeId);
        employeeDao.delete(employeeId);
        logger.info("deleted employee with id {}",employeeId);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        logger.debug("updating employee {}",employee);
        Employee oldEmployee=employeeDao.getEmployee(employee.getEmployeeId());
        if(oldEmployee==null){
            logger.error("Employee with id "+employee.getEmployeeId()+" not found");
            return null;
        }
        oldEmployee.setAddress(employee.getAddress());
        oldEmployee.setContact(employee.getContact());
        oldEmployee.setDob(employee.getDob());
        oldEmployee.setEmail(employee.getEmail());
        oldEmployee.setName(employee.getName());
        employee= employeeDao.save(oldEmployee);
        logger.info("updated employee {}",employee);
        return employee;
    }

    @Override
    public Project updateProjectForEmployee(Long employeeId, Project prj) {
        logger.info("updating project for employee with id {} project: {}",employeeId,prj);
        Employee employee=employeeDao.getEmployee(employeeId);
        if(employee==null){
            logger.error("Employee with id "+employeeId+" not found");
            return null;
        }
        Project project=employee.getProject();
        if(project==null){
           project=Project.builder()
                   .title(prj.getTitle())
                   .description(prj.getDescription())
                   .startDate(prj.getStartDate())
                   .endDate(prj.getEndDate())
                   .build();
        }
        else if(!Objects.equals(project.getProjectId(), prj.getProjectId())){
           logger.error("The updated project id {} is not equal to the old project id {} for employee with id {}",prj.getProjectId(),project.getProjectId(),employeeId);
            return null;
        }
        else{
            project.setTitle(prj.getTitle());
            project.setDescription(prj.getDescription());
            project.setStartDate(prj.getStartDate());
            project.setEndDate(prj.getEndDate());
        }
        employee.setProject(project);
        employeeDao.save(employee);
        logger.info("updated project for employee with id {} project: {}",employeeId,project);
        return project;
    }


    @Override
    public void assignDepartment(Long employeeId, Long departmentId) {
        logger.info("assigning department to employee with id {} department: {}",employeeId,departmentId);
        Employee employee=employeeDao.getEmployee(employeeId);
        if(employee==null){
            logger.error("Employee with id "+employeeId+" not found");
            return;
        }
        Department department=employee.getDepartment();
        if(department==null){
            logger.error("Department with id "+departmentId+" not found");
        }
        employee.setDepartment(department);
        employeeDao.save(employee);
        logger.info("assigned department to employee with id {} department: {}",employeeId,department);
    }

    @Override
    public Project createProjectForEmployee(Long employeeId, Project project) {
        logger.info("creating project for employee with id {} project: {}",employeeId,project);
        Employee employee=employeeDao.getEmployee(employeeId);
        if(employee==null){
            logger.error("Employee with id "+employeeId+" not found");
            return null;
        }
        employee.setProject(project);
        employeeDao.save(employee);
        logger.info("created project for employee with id {} project: {}",employeeId,project);
        return project;
    }

}
