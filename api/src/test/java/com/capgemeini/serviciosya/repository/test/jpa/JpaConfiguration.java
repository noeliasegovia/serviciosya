package com.capgemeini.serviciosya.repository.test.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableJpaRepositories (basePackages = {"com.capgemeini.serviciosya.repository"})
@EnableTransactionManagement
public class JpaConfiguration {

    private Environment env = null;


    public JpaConfiguration() {

        super ();
    }


    @Autowired
    public void setEnvironment (Environment env) {

        this.env = env;
    }


    @Bean
    public DataSource dataSource () {

        return DataSourceBuilder.create ()
                .username (env.getProperty ("db.username"))
                .password (env.getProperty ("db.password"))
                .url (env.getProperty ("db.url"))
                .driverClassName (env.getProperty ("db.driver"))
                .build ();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean ();
        entityManagerFactory.setDataSource (dataSource);


        entityManagerFactory.setPackagesToScan (env.getProperty ("entitymanager.packagesToScan"));

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter ();
        entityManagerFactory.setJpaVendorAdapter (vendorAdapter);

        Properties additionalProperties = new Properties ();
        additionalProperties.put ("hibernate.dialect", env.getProperty ("hibernate.dialect"));
        additionalProperties.put ("hibernate.show_sql", env.getProperty ("hibernate.show_sql"));
        additionalProperties.put ("hibernate.hbm2ddl.auto", env.getProperty ("hibernate.hbm2ddl.auto"));

        entityManagerFactory.setJpaProperties (additionalProperties);


        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager (EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager transactionManager = new JpaTransactionManager ();
        transactionManager.setEntityManagerFactory (entityManagerFactory);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation () {

        return new PersistenceExceptionTranslationPostProcessor ();
    }

}
