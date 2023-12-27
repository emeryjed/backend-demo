package com.ppe.assessment.assessment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.ppe.assessment.assessment1.repositories")
public class Assessment1Application {

    public static void main(String[] args) {
        SpringApplication.run(Assessment1Application.class, args);
    }

}
