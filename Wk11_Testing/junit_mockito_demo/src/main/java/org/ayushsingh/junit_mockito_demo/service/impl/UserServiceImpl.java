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

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

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

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

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