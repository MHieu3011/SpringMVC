package com.ptit.config;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = { "com.ptit.repository" })
@EnableTransactionManagement
public class JPAConfig {

	private ResourceBundle bundle = ResourceBundle.getBundle("db");

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPersistenceUnitName("persistence-data");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(bundle.getString("driverName"));
		dataSource.setUrl(bundle.getString("url"));
		dataSource.setUsername(bundle.getString("username"));
		dataSource.setPassword(bundle.getString("password"));
		return dataSource;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
//		properties.setProperty("hibernate.hbm2ddl.auto", "update");
//		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.hbm2ddl.auto", "none");
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		return properties;
	}
}
