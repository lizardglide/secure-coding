package com.home.secure.coding.sql.injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.home.secure.coding")
@EntityScan(basePackages = "come.home.secure.coding")
@SpringBootApplication
public class SqlInjectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlInjectionApplication.class, args);
    }
}
