package org.ayushsingh.junit_mockito_demo.dto;


import lombok.*;

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
