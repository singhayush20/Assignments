package org.ayushsingh.jdbc_jpa_demo.dao.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.ayushsingh.jdbc_jpa_demo.dao.EmployeeDao;
import org.ayushsingh.jdbc_jpa_demo.entity.Department;
import org.ayushsingh.jdbc_jpa_demo.entity.Employee;
import org.ayushsingh.jdbc_jpa_demo.entity.Project;
import org.ayushsingh.jdbc_jpa_demo.util.exceptionUtil.ApiException;
import org.springframework.stereotype.Component;

import java.util.Objects;


/**
 * Implementation of the {@link EmployeeDao} interface for performing CRUD operations related to employees.
 * Uses JPA for database interaction.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
@Component
@RequiredArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {
    private final EntityManagerFactory entityManagerFactory;


    /**
     * Saves an employee entity.
     *
     * @param employee The employee entity to be saved.
     * @return The saved {@link Employee} entity.
     */
    @Override
    public Employee save(Employee employee) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
      try{
          entityManager.getTransaction().begin();
          entityManager.persist(employee);
          entityManager.getTransaction().commit();
          return employee;
      }
      finally {
       if(entityManager.getTransaction().isActive())   {
           entityManager.getTransaction().rollback();
       }
       entityManager.close();
      }
    }

    /**
     * Deletes an employee by ID.
     *
     * @param employeeId The ID of the employee to be deleted.
     */
    @Override
    public void delete(Long employeeId) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Employee employee = entityManager.find(Employee.class, employeeId);
            entityManager.remove(employee);
            entityManager.getTransaction().commit();
        }
        finally {
            if(entityManager.getTransaction().isActive())   {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }


    /**
     * Assigns a department to an employee.
     *
     * @param employeeId   The ID of the employee.
     * @param departmentId The ID of the department to be assigned.
     */
    @Override
    public void assignDepartment(Long employeeId, Long departmentId) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Employee employee = entityManager.find(Employee.class, employeeId);
            if(employee==null){
                throw new ApiException("Employee not found");
            }
            Department department = entityManager.find(Department.class, departmentId);
            if(department==null){
                throw new ApiException("Department not found");
            }
            employee.setDepartment(department);
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
        }
        finally {
            if(entityManager.getTransaction().isActive())   {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }


    /**
     * Updates a project for an employee.
     *
     * @param employeeId The ID of the employee.
     * @param project    The project entity representing the updated project details.
     * @return The updated {@link Project} entity.
     */
    @Override
    public Project updateProjectForEmployee(Long employeeId, Project project) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Employee employee = entityManager.find(Employee.class, employeeId);
            if(employee==null){
                throw new ApiException("Employee not found");
            }
            Project oldProject=employee.getProject();
           if(oldProject==null){
               //if no previous project, save new
               employee.setProject(project);
           }
           else{
               if(!Objects.equals(oldProject.getProjectId(), project.getProjectId())){
                   //if old project id and new project id is not same, throw exception
                   throw new ApiException("The project with id "+project.getProjectId()+" does not exist");
               }
               oldProject.setTitle(project.getTitle());
               oldProject.setStartDate(project.getStartDate());
               oldProject.setEndDate(project.getEndDate());
               oldProject.setStartDate(project.getStartDate());
               employee.setProject(oldProject);
           }
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            return project;
        }
        finally {
            if(entityManager.getTransaction().isActive())   {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }


    /**
     * Assigns a new project to an employee.
     *
     * @param employeeId The ID of the employee.
     * @param project    The project entity representing the new project to be assigned.
     * @return The assigned {@link Project} entity.
     */
    @Override
    public Project assignNewProject(Long employeeId, Project project) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Employee employee = entityManager.find(Employee.class, employeeId);
            if(employee==null){
                throw new ApiException("Employee not found");
            }
            entityManager.remove(employee.getProject());
            employee.setProject(project);
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            return project;
        }
        finally {
            if(entityManager.getTransaction().isActive())   {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }
}
