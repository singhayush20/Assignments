package com.ayushsingh.service;

import com.ayushsingh.entity.Employee;
import com.ayushsingh.entity.Project;

public interface EmployeeService {
    Employee createEmployee(Employee employee); //create employee
    void deleteEmployee(Long employeeId); //delete employee
    Employee updateEmployee(Employee employee); //update employee

    Project updateProjectForEmployee(Long employeeId, Project project); //update project for employee
    void assignDepartment(Long employeeId, Long departmentId); //update department for employee

    Project createProjectForEmployee(Long employeeId, Project project); //create project for employee


}
