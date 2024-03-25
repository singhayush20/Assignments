package com.ayushsingh.ordermanagement;

import com.ayushsingh.ordermanagement.model.dto.Order.OrderCreateDto;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderItemDto;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderUpdateDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class OrderManagementApplicationTests {

    private static final String BASE_URL = "http://localhost:8085/api/v1/order";
    private static final String NEW_ORDER_ENDPOINT = "/new";
    private static final String ALL_ORDERS_ENDPOINT = "/all";



    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    void testCreateOrder() {
        OrderCreateDto orderCreateDto = new OrderCreateDto();
        orderCreateDto.setCustomerName("Ayush Singh");
        orderCreateDto.setAddress("Ayush's Address");
        Set<OrderItemDto> orderItems=new HashSet<>();
        String[] productsTokens={
                "a8152a2c-5a5b-40f4-8a16-ef6f70e81aae",
                "2f82b9d7-8029-4a9b-a59f-9a371cbdc68e",
                "6a7a3f9c-1f12-4c63-8bcb-75c12d8f8a17"
        };
        for(int i=0;i<productsTokens.length;i++){
            OrderItemDto orderItemDto = new OrderItemDto();
            orderItemDto.setProductToken(productsTokens[i]);
            orderItemDto.setQuantity((long) (i+1));
            orderItems.add(orderItemDto);
        }
        orderCreateDto.setProducts(orderItems);
        given()
                .contentType(ContentType.JSON)
                .body(orderCreateDto)
                .when()
                .post(NEW_ORDER_ENDPOINT)
                .then()
                .assertThat()
                .statusCode(201);
    }

    @Test
    void testGetOrderDetails() {
        String orderToken = "baa17db6-ee47-4fc3-ac83-055be028307a";

        given()
                .pathParam("orderToken", orderToken)
                .when()
                .get("/{orderToken}")
                .then()
                .assertThat()
                .statusCode(200)
                .body("data.customerName", equalTo("Ayush Singh"));
    }



    @Test
    void testUpdateOrder() {
        String orderToken = "baa17db6-ee47-4fc3-ac83-055be028307a";

        OrderUpdateDto orderUpdateDto = new OrderUpdateDto();
        orderUpdateDto.setCustomerName("Ayush Singh");
        orderUpdateDto.setAddress("Uttar Pradesh");

        given()
                .pathParam("orderToken", orderToken)
                .contentType(ContentType.JSON)
                .body(orderUpdateDto)
                .when()
                .patch("/{orderToken}")
                .then()
                .assertThat()
                .statusCode(200)
                .body("data", equalTo(orderToken));
    }

    @Test
    void testGetAllOrders() {
        given()
                .when()
                .get(ALL_ORDERS_ENDPOINT)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    void testCancelOrder() {
        String orderToken = "baa17db6-ee47-4fc3-ac83-055be028307a";

        given()
                .pathParam("orderToken", orderToken)
                .when()
                .delete("/{orderToken}")
                .then()
                .assertThat()
                .statusCode(200)
                .body("data", equalTo("Order with id: " + orderToken + " deleted successfully!"));
    }
}
