package com.ayushsingh.dao.impl;

import com.ayushsingh.dao.DepartmentDao;
import com.ayushsingh.entity.Department;
import jakarta.persistence.EntityManager;

public class DepartmentDaoImpl implements DepartmentDao {
    private final EntityManager entityManager;

    public DepartmentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Department create(Department department) {
        entityManager.getTransaction().begin();
        entityManager.persist(department);
        entityManager.getTransaction().commit();
        return department;
    }
}
