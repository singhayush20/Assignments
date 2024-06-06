package org.ayushsingh.junit_mockito_demo.dto;


import lombok.*;

/**
 * DTO class for {@link org.ayushsingh.junit_mockito_demo.entity.User} creation.
 *
 * @author Ayush Singh
 * @since 2024-04-12
 * @version 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterDto {


        private String username;

        private String password;

        private String name;

       private String email;

       private Long phone;
}
