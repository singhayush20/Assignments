package org.ayushsingh.junit_mockito_demo;

import org.ayushsingh.junit_mockito_demo.dto.UserDetailsDto;
import org.ayushsingh.junit_mockito_demo.dto.UserRegisterDto;
import org.ayushsingh.junit_mockito_demo.entity.User;
import org.ayushsingh.junit_mockito_demo.repository.UserRepository;
import org.ayushsingh.junit_mockito_demo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


/**
 * Unit tests for the {@link UserServiceImpl}.
 * This class tests the CRUD operations using Mockito
 *
 * @author Ayush Singh
 * @since 2024-04-12
 * @version 1.0.0
 */
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @Order(1)
    void testCreateUser() {
        UserRegisterDto userRegisterDto = UserRegisterDto.builder()
                .username("ayush")
                .password("123abc")
                .name("Ayush Singh")
                .email("ayushsingh20november@gmail.com")
                .phone(1234567890L)
                .build();
        User savedUser = new User(1L, "ayush", "123abc", "Ayush Singh", "ayushsingh20november@gmail.com", 1234567890L);
        when(userRepository.save(any(User.class))).thenReturn(savedUser);


        UserDetailsDto actualUserDto = userService.createUser(userRegisterDto);


        assertNotNull(actualUserDto.getUserId());
        assertEquals(userRegisterDto.getUsername(), actualUserDto.getUsername());
        assertEquals(userRegisterDto.getName(), actualUserDto.getName());
        assertEquals(userRegisterDto.getEmail(), actualUserDto.getEmail());
        assertEquals(userRegisterDto.getPhone(), actualUserDto.getPhone());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    @Order(2)
    void testGetUser() {

        Long userId = 1L;
        User user = new User(userId, "ayush", "123abc", "Ayush Singh", "ayushsingh20november@gmail.com", 7867564563L);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));


        UserDetailsDto actualUserDto = userService.getUser(userId);


        assertEquals(user.getUserId(), actualUserDto.getUserId());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    @Order(3)
    void testUpdateUser() {

        User user = new User(1L, "ayush", "123abc", "Ayush Singh", "ayushsingh20november@gmail.com", 7867564563L);
        User expectedUpdatedUser = new User(1L, "himanshu", "123abc123", "Himanshu Singh", "himanshur@gmail.com", 7867564563L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(expectedUpdatedUser);

        UserDetailsDto userDto = new UserDetailsDto(1L,"himanshu", "Himanshu Singh", "himanshur@gmail.com", 7867564563L);
        UserDetailsDto updatedUserDto = userService.updateUser(userDto);


        assertEquals(userDto.getUserId(), updatedUserDto.getUserId());
        assertEquals(userDto.getUsername(), updatedUserDto.getUsername());
        assertEquals(userDto.getName(), updatedUserDto.getName());
        assertEquals(userDto.getEmail(), updatedUserDto.getEmail());
        assertEquals(userDto.getPhone(), updatedUserDto.getPhone());
        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).save(any(User.class));
    }



    @Test
    @Order(4)
    void testDeleteUser() {
        Long userId = 1L;


        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }


    @Test
    @Order(5)
    void testGetAllUsers() {

        User user1 = new User(1L, "ayush", "123abc", "Ayush Singh", "ayushsingh20november@gmail.com", 7867564563L);
        User user2 = new User(2L, "himanshu", "123abc123", "Himanshu Singh", "himanshur@gmail.com", 7867564563L);
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));
        List<UserDetailsDto> expectedUserDtos = Arrays.asList(
                new UserDetailsDto(1L, "ayush", "Ayush Singh", "ayushsingh20november@gmail.com", 7867564563L),
                new UserDetailsDto(2L, "himanshu", "Himanshu Singh", "himanshur@gmail.com", 7867564563L)
        );


        List<UserDetailsDto> actualUserDtos = userService.getAllUsers();


        assertEquals(expectedUserDtos.size(), actualUserDtos.size());
        for (int i = 0; i < expectedUserDtos.size(); i++) {
            assertEquals(expectedUserDtos.get(i).getUserId(), actualUserDtos.get(i).getUserId());
        }
        verify(userRepository, times(1)).findAll();
    }


}
