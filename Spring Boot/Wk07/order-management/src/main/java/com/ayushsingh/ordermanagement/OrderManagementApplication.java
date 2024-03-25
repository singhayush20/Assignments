package com.ayushsingh.ordermanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderManagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OrderManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Order Management Service is up and running!");
    }
}
