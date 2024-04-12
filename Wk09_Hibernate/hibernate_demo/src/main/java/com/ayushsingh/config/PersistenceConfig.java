package com.ayushsingh.config;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

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
        // - use the Hikari Connection Pool Datasource
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost/jpa_hibernate_demo");
        dataSource.setUsername("hbstudent");
        dataSource.setPassword("hbstudent");

        return dataSource;
    }

    @Override
    public List<String> getManagedClassNames() {
        // - list all the entities
        return Arrays.asList("com.ayushsingh.entity.Employee",
                "com.ayushsingh.entity.Department",
                "com.ayushsingh.entity.Project");
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

        // Enable Hibernate's automatic table creation/update
        properties.put(AvailableSettings.HBM2DDL_AUTO, "update"); //-for demo purpose only
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
