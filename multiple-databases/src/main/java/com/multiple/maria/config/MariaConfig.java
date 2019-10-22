package com.multiple.maria.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mariaEntityManagerFactory", transactionManagerRef = "mariaTransactionManager", basePackages = {
		"com.multiple.maria" })
public class MariaConfig {
	@Primary
	@Bean(name = "mariaDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return org.springframework.boot.jdbc.DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "mariaEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("mariaDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.multiple.maria.entity").persistenceUnit("maria")
				.properties(jpaProperties()).build();
	}

	private Map<String, Object> jpaProperties() {
		Map<String, Object> props = new HashMap<>();
		props.put("spring.jpa.hibernate.naming.physical-strategy", PhysicalNamingStrategyStandardImpl.class.getName());
		props.put("spring.jpa.hibernate.naming.implicit-strategy", ImplicitNamingStrategy.class.getName());
		return props;
	}

	@Primary
	@Bean(name = "mariaTransactionManager")
	public PlatformTransactionManager barTransactionManager(
			@Qualifier("mariaEntityManagerFactory") EntityManagerFactory barEntityManagerFactory) {
		return new JpaTransactionManager(barEntityManagerFactory);
	}
}
