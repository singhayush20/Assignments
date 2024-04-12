package com.ayushsingh.dao.impl;

import com.ayushsingh.dao.ProjectDao;
import com.ayushsingh.entity.Project;
import jakarta.persistence.EntityManager;

public class ProjectDaoImpl implements ProjectDao {

    private final EntityManager entityManager;

    public ProjectDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Project create(Project project) {
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
        return project;
    }
}
