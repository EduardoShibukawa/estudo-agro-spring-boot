package com.github.eduardoshibukawa.totvsagro.configuration;

import java.util.Map;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest {
	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

		static AgroPostgresqlContainer postgres = AgroPostgresqlContainer.getInstance();

		@Override
		public void initialize(ConfigurableApplicationContext applicationContext) {
			configurePostgresSystemProperties(applicationContext);			
		}

		private void configurePostgresSystemProperties(ConfigurableApplicationContext applicationContext) {
			Map<String, Object> systemProperties = applicationContext.getEnvironment().getSystemProperties();
			
			systemProperties.put("spring.datasource.url", postgres.getJdbcUrl());
			systemProperties.put("spring.datasource.username", postgres.getUsername());
			systemProperties.put("spring.datasource.password", postgres.getPassword());
			systemProperties.put("spring.datasource.driver-class-name", postgres.getDriverClassName());
			
			systemProperties.put("flyway.driver", postgres.getDriverClassName());
			systemProperties.put("flyway.url", postgres.getJdbcUrl());
			systemProperties.put("flyway.schema", postgres.getDatabaseName());
			systemProperties.put("flyway.user", postgres.getUsername());
  			systemProperties.put("flyway.password", postgres.getPassword());
		}
	}
}
