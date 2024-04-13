package org.ayushsingh.junit_mockito_demo.controller;

import lombok.RequiredArgsConstructor;
import org.ayushsingh.junit_mockito_demo.dto.UserDetailsDto;
import org.ayushsingh.junit_mockito_demo.dto.UserRegisterDto;
import org.ayushsingh.junit_mockito_demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDetailsDto> createUser(@RequestBody UserRegisterDto userRegisterDto) {
        UserDetailsDto userDetailsDto = userService.createUser(userRegisterDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetailsDto);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetailsDto> getUser(@PathVariable Long userId) {
        UserDetailsDto userDetailsDto = userService.getUser(userId);
        if (userDetailsDto != null) {
            return ResponseEntity.ok(userDetailsDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDetailsDto>> getAllUsers() {
        List<UserDetailsDto> userDetailsDtoList = userService.getAllUsers();
        return ResponseEntity.ok(userDetailsDtoList);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<UserDetailsDto> updateUser(@RequestBody UserDetailsDto userDetailsDto) {
        UserDetailsDto updatedUser = userService.updateUser(userDetailsDto);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
