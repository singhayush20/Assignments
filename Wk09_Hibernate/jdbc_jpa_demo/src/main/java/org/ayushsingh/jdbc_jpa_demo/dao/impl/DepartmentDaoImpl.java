package org.ayushsingh.jdbc_jpa_demo.dao.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.ayushsingh.jdbc_jpa_demo.dao.DepartmentDao;
import org.ayushsingh.jdbc_jpa_demo.entity.Department;
import org.springframework.stereotype.Component;


/**
 * Implementation of the {@link DepartmentDao} interface for performing CRUD operations related to employees.
 * Uses JPA for database interaction.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
@Component
@RequiredArgsConstructor
public class DepartmentDaoImpl implements DepartmentDao {
    private final EntityManagerFactory entityManagerFactory;



    /**
     * Creates a new department in the database.
     *
     * @param department The department object to be created.
     * @return The created department object.
     */
    @Override
    public Department create(Department department) {

           EntityManager entityManager = entityManagerFactory.createEntityManager();
       try{
           entityManager.getTransaction().begin();
           entityManager.persist(department);
           entityManager.getTransaction().commit();
           return department;
       }

       finally {
           if(entityManager.getTransaction().isActive()){
               entityManager.getTransaction().rollback();
           }
           entityManager.close();
       }
    }
}


