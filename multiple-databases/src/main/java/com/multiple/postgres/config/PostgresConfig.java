package com.multiple.postgres.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.PostgreSQL10Dialect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "postgresEntityManagerFactory", transactionManagerRef = "postgresTransactionManager", basePackages = {
		"com.multiple.postgres" })
public class PostgresConfig {
	@Bean(name = "postgresDataSource")
	@ConfigurationProperties(prefix = "postgres.datasource")
	public DataSource dataSource() {
		return org.springframework.boot.jdbc.DataSourceBuilder.create().build();
	}

	@Bean(name = "postgresEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("postgresDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.multiple.postgres.entity").persistenceUnit("postgres")
				.properties(jpaProperties()).build();
	}

	protected Map<String, Object> jpaProperties() {
		Map<String, Object> props = new HashMap<>();
		props.put("spring.jpa.properties.hibernate.dialect", PostgreSQL10Dialect.class.getName());
		return props;
	}

	@Bean(name = "postgresTransactionManager")
	public PlatformTransactionManager barTransactionManager(
			@Qualifier("postgresEntityManagerFactory") EntityManagerFactory barEntityManagerFactory) {
		return new JpaTransactionManager(barEntityManagerFactory);
	}
}
