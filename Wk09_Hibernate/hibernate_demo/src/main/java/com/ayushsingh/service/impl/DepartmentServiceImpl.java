package com.ayushsingh.service.impl;

import com.ayushsingh.dao.DepartmentDao;
import com.ayushsingh.entity.Department;
import com.ayushsingh.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
    @Override
    public Department create(Department department) {
        return departmentDao.create(department);
    }
}
