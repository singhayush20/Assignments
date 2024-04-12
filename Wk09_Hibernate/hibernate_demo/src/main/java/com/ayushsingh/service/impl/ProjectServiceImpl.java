package com.ayushsingh.service.impl;

import com.ayushsingh.dao.ProjectDao;
import com.ayushsingh.entity.Project;
import com.ayushsingh.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {
    private final ProjectDao projectDao;

    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public Project createProject(Project project) {
        return projectDao.create(project);
    }
}
