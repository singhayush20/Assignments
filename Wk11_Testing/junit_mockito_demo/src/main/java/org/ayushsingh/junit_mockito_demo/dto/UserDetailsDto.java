package org.ayushsingh.junit_mockito_demo.dto;

import lombok.*;
import org.ayushsingh.junit_mockito_demo.service.impl.UserServiceImpl;

import java.util.Set;

/**
 * DTO class for {@link org.ayushsingh.junit_mockito_demo.entity.User} details.
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
public class UserDetailsDto {

    private Long userId;

    private String username;

    private String name;

    private String email;

    private Long phone;

}
