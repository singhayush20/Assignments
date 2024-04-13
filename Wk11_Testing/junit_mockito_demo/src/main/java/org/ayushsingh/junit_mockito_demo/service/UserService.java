package org.ayushsingh.junit_mockito_demo.service;

import org.ayushsingh.junit_mockito_demo.dto.UserDetailsDto;
import org.ayushsingh.junit_mockito_demo.dto.UserRegisterDto;

import java.util.List;

public interface UserService {

    UserDetailsDto createUser(UserRegisterDto userRegisterDto);

    UserDetailsDto getUser(Long userId);

    List<UserDetailsDto> getAllUsers();

    void deleteUser(Long userId);

    UserDetailsDto updateUser(UserDetailsDto userDto);
}
