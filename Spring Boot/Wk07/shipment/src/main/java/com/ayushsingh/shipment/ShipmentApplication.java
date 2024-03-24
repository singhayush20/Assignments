package com.ayushsingh.shipment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShipmentApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ShipmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Shipment service is up and running...");
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
