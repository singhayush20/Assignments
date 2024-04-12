package com.ayushsingh.dao;

import com.ayushsingh.entity.Employee;

public interface EmployeeDao {
    Employee save(Employee employee);
    void delete(Long employeeId);
    void assignDepartment(Long employeeId, Long departmentId);

    Employee getEmployee(Long employeeId);
}
