package org.ayushsingh.jdbc_jpa_demo.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;
import org.hibernate.cfg.AvailableSettings;

import javax.sql.DataSource;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Configuration class for defining persistence unit information.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
public class PersistenceConfig implements PersistenceUnitInfo {

    @Override
    public void addTransformer(ClassTransformer arg0) {

    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public List<URL> getJarFileUrls() {
        return null;
    }

    @Override
    public DataSource getJtaDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost/jpa_hibernate_demo");
        dataSource.setUsername("hbstudent");
        dataSource.setPassword("hbstudent");

        return dataSource;
    }

    @Override
    public List<String> getManagedClassNames() {
        return Arrays.asList("org.ayushsingh.jdbc_jpa_demo.entity.Employee",
                "org.ayushsingh.jdbc_jpa_demo.entity.Department",
                "org.ayushsingh.jdbc_jpa_demo.entity.Project");
    }

    @Override
    public List<String> getMappingFileNames() {
        return null;
    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public String getPersistenceProviderClassName() {
        return "org.hibernate.jpa.HibernatePersistenceProvider";
    }

    @Override
    public String getPersistenceUnitName() {
        return "my-persistence-unit";
    }

    @Override
    public URL getPersistenceUnitRootUrl() {

        return null;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {

        return null;
    }

    @Override
    public Properties getProperties() {
        Properties properties = new Properties();

        properties.put(AvailableSettings.HBM2DDL_AUTO, "update"); //for demo purpose, use update/create (don't use in production)
        properties.put(AvailableSettings.FORMAT_SQL, true);
        properties.put(AvailableSettings.SHOW_SQL, true);

        // Specify the dialect for your database (e.g., MySQL)
        properties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQLDialect");

        return properties;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {

        return null;
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {

        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    @Override
    public ValidationMode getValidationMode() {

        return null;
    }

}
