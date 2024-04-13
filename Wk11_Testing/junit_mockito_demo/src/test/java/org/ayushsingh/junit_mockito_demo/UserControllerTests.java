package org.ayushsingh.junit_mockito_demo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.ayushsingh.junit_mockito_demo.dto.UserDetailsDto;
import org.ayushsingh.junit_mockito_demo.dto.UserRegisterDto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class UserControllerTests {

    private static Long userId;

    @BeforeAll
    public static void setUp() {
        final String BASE_URL = "http://localhost:8086" + "/api/v1/user";
        RestAssured.baseURI = BASE_URL;
        userId=1L;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @Order(1)
    public void testCreateUser() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setName("Ayush Singh");
        userRegisterDto.setEmail("ayushsingh20april@gmail.com");
        userRegisterDto.setUsername("ayush_20");
        userRegisterDto.setPhone(7867567434L);
        userRegisterDto.setPassword("password");

        given()
                .contentType(ContentType.JSON)
                .body(userRegisterDto)
                .when()
                .post("/create")
                .then()
                .statusCode(201)
                .body("name", equalTo(userRegisterDto.getName()))
                .body("email", equalTo(userRegisterDto.getEmail()))
                .body("username", equalTo(userRegisterDto.getUsername()))
                .body("phone", equalTo(userRegisterDto.getPhone()));


    }

    @Test
    @Order(2)
    public void testGetUser() {
        given()
                .when()
                .get("/{userId}", userId)
                .then()
                .statusCode(200)
                .body("name", notNullValue())
                .body("email", notNullValue())
                .body("username", notNullValue())
                .body("phone", notNullValue());
    }

    @Test
    @Order(3)
    public void testGetAllUsers() {
        given()
                .when()
                .get("/all")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Order(4)
    public void testUpdateUser() {
        UserDetailsDto userDetailsDto = new UserDetailsDto();
        userDetailsDto.setUserId(userId);
        userDetailsDto.setName("Ayush Pratap Singh");
        userDetailsDto.setEmail("ayush@outlook.com");
        userDetailsDto.setUsername("ayush201");
        userDetailsDto.setPhone(6756473234L);

        given()
                .contentType(ContentType.JSON)
                .body(userDetailsDto)
                .when()
                .put("/update")
                .then()
                .statusCode(200)
                .body("name", equalTo(userDetailsDto.getName()))
                .body("email", equalTo(userDetailsDto.getEmail()))
                .body("username", equalTo(userDetailsDto.getUsername()))
                .body("phone", equalTo(userDetailsDto.getPhone()));
    }

    @Test
    @Order(5)
    public void testDeleteUser() {
        given()
                .when()
                .delete("/{userId}", userId)
                .then()
                .statusCode(204);
    }
}
