package org.ayushsingh.junit_mockito_demo.service;

import org.ayushsingh.junit_mockito_demo.dto.UserDetailsDto;
import org.ayushsingh.junit_mockito_demo.dto.UserRegisterDto;

import java.util.List;

/**
 * Service interface for managing user-related operations.
 * This interface defines methods to create, retrieve, update, and delete users,
 * as well as retrieve a list of all users.
 *
 * @author Ayush Singh
 * @since 2024-04-12
 * @version 1.0.0
 */
public interface UserService {

    UserDetailsDto createUser(UserRegisterDto userRegisterDto);

    UserDetailsDto getUser(Long userId);

    List<UserDetailsDto> getAllUsers();

    void deleteUser(Long userId);

    UserDetailsDto updateUser(UserDetailsDto userDto);
}
