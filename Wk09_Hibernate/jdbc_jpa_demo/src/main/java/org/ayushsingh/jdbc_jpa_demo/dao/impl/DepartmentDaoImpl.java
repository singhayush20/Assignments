package org.ayushsingh.jdbc_jpa_demo.dao.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.ayushsingh.jdbc_jpa_demo.dao.DepartmentDao;
import org.ayushsingh.jdbc_jpa_demo.entity.Department;
import org.hibernate.property.access.spi.PropertyAccessException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentDaoImpl implements DepartmentDao {
    private final EntityManagerFactory entityManagerFactory;



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


