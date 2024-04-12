package org.ayushsingh.jdbc_jpa_demo;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class JdbcJpaDemoApplication implements CommandLineRunner {

    private final Logger logger= LoggerFactory.getLogger(JdbcJpaDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JdbcJpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Application is running...");
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
