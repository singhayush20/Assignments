package com.ayushsingh.dao.impl;

import com.ayushsingh.dao.EmployeeDao;
import com.ayushsingh.entity.Department;
import com.ayushsingh.entity.Employee;
import jakarta.persistence.EntityManager;

public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee save(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        return employee;
    }

    @Override
    public void delete(Long employeeId) {
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, employeeId);
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
    }





    @Override
    public void assignDepartment(Long employeeId, Long departmentId) {
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, employeeId);
        employee.setDepartment(entityManager.getReference(Department.class, departmentId));
        entityManager.getTransaction().commit();
    }

    @Override
    public Employee getEmployee(Long employeeId) {
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, employeeId);
        entityManager.getTransaction().commit();
        return employee;
    }
}
