package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            
            bookstoreService.persistAuthor();
            bookstoreService.displayAuthor();
        };
    }
}
/*
 * 
 * 
 * View Binding/Extracted Params Via Log4J 2

Description: View the prepared statement binding/extracted parameters via Log4J 2 logger setting.

Key points:

for Maven, in pom.xml, exclude Spring Boot's Default Logging
for Maven, in pom.xml, Add Log4j 2 Dependency
in log4j2.xml add, <Logger name="org.hibernate.type.descriptor.sql" level="trace"/>
Output example:
 * 
 */
