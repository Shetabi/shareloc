package com.shareloc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
public class JpaDatabaseConnectionTest {

    @Autowired
    private HelloRepository sut;

    @Container
    private static final MySQLContainer<?> db = new MySQLContainer<>(DockerImageName.parse("mysql:8.0"))
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test");


    @Test
    void testRepositoryMappingIsCorrect() {
        HelloEntity ent = new HelloEntity();
        ent.setId(1);
        ent.setMessage("Hello from outside");

        HelloEntity save = sut.save(ent);

        Assertions.assertNotNull(save);

    }


    @DynamicPropertySource
    public static void setDynamicUrl(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", db::getJdbcUrl);
    }
}
