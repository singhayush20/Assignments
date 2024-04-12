package org.ayushsingh.jdbc_jpa_demo.dao;

import org.ayushsingh.jdbc_jpa_demo.entity.Employee;
import org.ayushsingh.jdbc_jpa_demo.entity.Project;

/**
 * Interface for performing CRUD operations related to employees and their projects.
 * Defines methods for saving, deleting, and updating employee and project entities.
 * Also includes methods for assigning departments and new projects to employees.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
public interface EmployeeDao {
    Employee save(Employee employee);
    void delete(Long employeeId);
    void assignDepartment(Long employeeId, Long departmentId);

    Project updateProjectForEmployee(Long employeeId, Project project);


    Project assignNewProject(Long employeeId, Project project);
}
