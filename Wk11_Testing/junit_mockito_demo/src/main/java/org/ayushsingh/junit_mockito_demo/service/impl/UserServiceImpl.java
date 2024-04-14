package org.ayushsingh.junit_mockito_demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.ayushsingh.junit_mockito_demo.dto.UserDetailsDto;
import org.ayushsingh.junit_mockito_demo.dto.UserRegisterDto;
import org.ayushsingh.junit_mockito_demo.entity.User;
import org.ayushsingh.junit_mockito_demo.repository.UserRepository;
import org.ayushsingh.junit_mockito_demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the UserService interface to manage user-related operations.
 * This service class provides methods to create, retrieve, update, and delete user information.
 *
 * @author Ayush Singh
 * @since 2024-04-12
 * @version 1.0.0
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    /**
     * Create a new user with the provided details.
     *
     * @param userRegisterDto The details of the user to be created.
     * @return UserDetailsDto with the details of the created user.
     */
    @Override
    public UserDetailsDto createUser(UserRegisterDto userRegisterDto) {
        User newUser = new User();
        newUser.setUsername(userRegisterDto.getUsername());
        newUser.setPassword(userRegisterDto.getPassword());
        newUser.setName(userRegisterDto.getName());
        newUser.setEmail(userRegisterDto.getEmail());
        newUser.setPhone(userRegisterDto.getPhone());

        User savedUser=userRepository.save(newUser);
        return UserDetailsDto.builder()
                .userId(savedUser.getUserId())
                .username(savedUser.getUsername())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .phone(savedUser.getPhone())
                .build();
    }


    /**
     * Retrieve user details by userId.
     *
     * @param userId The unique identifier of the user.
     * @return UserDetailsDto with the details of the user if found, otherwise null.
     */
    @Override
    public UserDetailsDto getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return null;
        }
        return UserDetailsDto.builder()
                .userId(user.get().getUserId())
                .username(user.get().getUsername())
                .name(user.get().getName())
                .email(user.get().getEmail())
                .phone(user.get().getPhone())
                .build();
    }


    /**
     * Retrieve details of all users.
     *
     * @return List<UserDetailsDto> with details of all users.
     */
    @Override
    public List<UserDetailsDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> {
            UserDetailsDto userDetailsDto = new UserDetailsDto();
            userDetailsDto.setUserId(user.getUserId());
            userDetailsDto.setUsername(user.getUsername());
            userDetailsDto.setName(user.getName());
            userDetailsDto.setEmail(user.getEmail());
            userDetailsDto.setPhone(user.getPhone());
            return userDetailsDto;
        }).collect(Collectors.toList());
    }


    /**
     * Delete a user by userId.
     *
     * @param userId The unique identifier of the user to be deleted.
     */
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


    /**
     * Update user details.
     *
     * @param userDto The updated details of the user.
     * @return UserDetailsDto with the updated user details if found, otherwise null.
     */
    @Override
    public UserDetailsDto updateUser(UserDetailsDto userDto) {
        Optional<User> userOptional = userRepository.findById(userDto.getUserId());
        if (userOptional.isEmpty()) {
            return null;
        }
        User user = userOptional.get();
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        return UserDetailsDto.builder()
                .userId(userRepository.save(user).getUserId())
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }
}