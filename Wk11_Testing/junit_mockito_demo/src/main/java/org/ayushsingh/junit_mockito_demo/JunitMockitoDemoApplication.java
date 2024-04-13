package org.ayushsingh.junit_mockito_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JunitMockitoDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JunitMockitoDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application is running...");
    }

}
