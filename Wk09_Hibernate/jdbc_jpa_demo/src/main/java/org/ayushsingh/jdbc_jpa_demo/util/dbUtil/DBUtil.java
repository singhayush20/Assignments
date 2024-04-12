package org.ayushsingh.jdbc_jpa_demo.util.dbUtil;

import jakarta.persistence.EntityManagerFactory;
import org.ayushsingh.jdbc_jpa_demo.config.PersistenceConfig;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;


/**
 * Utility class for managing the database.
 * Provides a method {@link #getEntityManagerFactory()} to obtain the {@link EntityManagerFactory} bean for database operations.
 * Avoid creating multiple {@link EntityManagerFactory} beans.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
@Configuration
public class DBUtil {

    @Bean
    public EntityManagerFactory getEntityManagerFactory() {
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new PersistenceConfig(), new HashMap<>());
        return emf;
    }
}
