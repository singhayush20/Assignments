package org.ayushsingh.jdbc_jpa_demo.dao;

import org.ayushsingh.jdbc_jpa_demo.entity.Department;

/**
 * Interface for performing CRUD operations related to departments.
 * Defines a method for creating a new department entity.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
public interface DepartmentDao {
    Department create(Department department);
}
