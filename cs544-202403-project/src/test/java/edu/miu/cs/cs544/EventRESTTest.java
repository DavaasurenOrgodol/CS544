package edu.miu.cs.cs544;

import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.service.contract.EventPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class EventRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = 8080;
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/badge-system";
    }

    @Test
    public void testEvent() {
        // Create event
        EventPayload eventPayload = new EventPayload("CS544", "EA", AccountType.ATTENDANCE_POINTS,
                LocalDateTime.now(), LocalDateTime.now());
        given()
                .auth()
                .basic("user", "123")
                .contentType(ContentType.JSON)
                .body(eventPayload)
                .when().post("/events")
                .then()
                .statusCode(200);

        // Test getting the events
        given()
                .auth()
                .basic("user", "123")
                .when()
                .get("/events")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("content", hasSize(1));

        // Cleanup - Delete the event
        given()
                .auth()
                .basic("user", "123")
                .when()
                .delete("/events/1")
                .then()
                .statusCode(200);
    }
}

