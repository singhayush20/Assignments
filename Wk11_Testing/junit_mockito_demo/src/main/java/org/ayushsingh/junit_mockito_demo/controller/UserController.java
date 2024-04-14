package org.ayushsingh.junit_mockito_demo.controller;

import lombok.RequiredArgsConstructor;
import org.ayushsingh.junit_mockito_demo.dto.UserDetailsDto;
import org.ayushsingh.junit_mockito_demo.dto.UserRegisterDto;
import org.ayushsingh.junit_mockito_demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class to handle user-related HTTP requests.
 * This controller provides endpoints for creating, retrieving, updating, and deleting user information.
 *
 * @author Ayush Singh
 * @version 1.0.0
 * @since 2024-04-12
 */
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    /**
     * Endpoint to create a new user.
     *
     * @param userRegisterDto The details of the user to be created.
     * @return ResponseEntity with the created user details.
     */
    @PostMapping("/create")
    public ResponseEntity<UserDetailsDto> createUser(@RequestBody UserRegisterDto userRegisterDto) {
        UserDetailsDto userDetailsDto = userService.createUser(userRegisterDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetailsDto);
    }

    /**
     * Endpoint to retrieve user details by userId.
     *
     * @param userId The unique identifier of the user.
     * @return ResponseEntity with the user details.
     */
    @GetMapping("/{userId}")
    public ResponseEntity<UserDetailsDto> getUser(@PathVariable Long userId) {
        UserDetailsDto userDetailsDto = userService.getUser(userId);

        return ResponseEntity.ok(userDetailsDto);

    }

    /**
     * Endpoint to retrieve details of all users.
     *
     * @return ResponseEntity with a list of all users' details.
     */
    @GetMapping("/all")
    public ResponseEntity<List<UserDetailsDto>> getAllUsers() {
        List<UserDetailsDto> userDetailsDtoList = userService.getAllUsers();
        return ResponseEntity.ok(userDetailsDtoList);
    }

    /**
     * Endpoint to delete a user by userId.
     *
     * @param userId The unique identifier of the user to be deleted.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Endpoint to update user details.
     *
     * @param userDetailsDto The updated details of the user.
     * @return ResponseEntity with the updated user details.
     */
    @PutMapping("/update")
    public ResponseEntity<UserDetailsDto> updateUser(@RequestBody UserDetailsDto userDetailsDto) {
        UserDetailsDto updatedUser = userService.updateUser(userDetailsDto);

        return ResponseEntity.ok(updatedUser);
    }
}
