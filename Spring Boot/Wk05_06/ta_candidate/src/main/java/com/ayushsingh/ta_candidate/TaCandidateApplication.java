package com.ayushsingh.ta_candidate;

import com.ayushsingh.ta_candidate.config.drive.DriveConfigurationProperties;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;

@SpringBootApplication
@EnableConfigurationProperties({DriveConfigurationProperties.class})

public class TaCandidateApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TaCandidateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application is up and running!");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
