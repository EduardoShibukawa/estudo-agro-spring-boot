package com.github.eduardoshibukawa.totvsagro.configuration;

import java.util.Objects;

import org.testcontainers.containers.PostgreSQLContainer;

public class AgroPostgresqlContainer extends PostgreSQLContainer<AgroPostgresqlContainer> {
	
    private static final String IMAGE_VERSION = "postgres:13.0";

    private static AgroPostgresqlContainer container = null;


    private AgroPostgresqlContainer() {
        super(IMAGE_VERSION);
    }

    public static AgroPostgresqlContainer getInstance() {
        if (Objects.isNull(container)) {
            container = new AgroPostgresqlContainer();
            container
	            .withDatabaseName("agro")
	            .withUsername("agro")
	            .withPassword("agro")
	            .start();
        }
        return container;
    }
    
    @Override
    public void stop() {}
}
