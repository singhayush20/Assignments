package org.ayushsingh.junit_mockito_demo.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailsDto {

    private Long userId;

    private String username;

    private String name;

    private String email;

    private Long phone;

}
