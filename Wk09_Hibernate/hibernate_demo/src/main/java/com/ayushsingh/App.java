package com.ayushsingh;

import com.ayushsingh.config.PersistenceConfig;
import com.ayushsingh.dao.DepartmentDao;
import com.ayushsingh.dao.EmployeeDao;
import com.ayushsingh.dao.ProjectDao;
import com.ayushsingh.dao.impl.DepartmentDaoImpl;
import com.ayushsingh.dao.impl.EmployeeDaoImpl;
import com.ayushsingh.dao.impl.ProjectDaoImpl;
import com.ayushsingh.entity.Department;
import com.ayushsingh.entity.Project;
import com.ayushsingh.service.DepartmentService;
import com.ayushsingh.service.EmployeeService;
import com.ayushsingh.service.ProjectService;
import com.ayushsingh.service.impl.DepartmentServiceImpl;
import com.ayushsingh.service.impl.EmployeeServiceImpl;
import com.ayushsingh.service.impl.ProjectServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;


public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new PersistenceConfig(), new HashMap<>());
        EntityManager em = emf.createEntityManager();

        EmployeeDao employeeDao = new EmployeeDaoImpl(em);
        EmployeeService employeeService = new EmployeeServiceImpl(employeeDao);

        ProjectDao projectDao = new ProjectDaoImpl(em);
        ProjectService projectService = new ProjectServiceImpl(projectDao);

        DepartmentDao departmentDao = new DepartmentDaoImpl(em);
        DepartmentService departmentService = new DepartmentServiceImpl(departmentDao);

        //for demo purpose, use a for loop to create 6 departments
        for (int i = 1; i <= 6; i++) {
            Department department = Department.builder()
                    .technology("Technology " + i)
                    .name("Department " + i)
                    .address("Address " + i)
                    .contact(1234567890L)
                    .build();
            department = departmentService.create(department);
            System.out.println("Department created... " + department);
        }



    }
}
