package edu.miu.cs.cs544;

import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.service.contract.EventPayload;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
public class EventRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080); // Port where your application is running
        RestAssured.baseURI = "http://localhost"; // Base URI of your application
        RestAssured.basePath = "/badge-system"; // Base path of your application
    }

    @Test
    public void testEventCRUDOperations() {
        // Create operation
        EventPayload eventPayload = new EventPayload("Test Event", "Description of Test Event", AccountType.ATTENDANCE_POINTS);
        given()
                .auth()
                .basic("user", "123")
                .contentType("application/json")
                .body(eventPayload)
                .when().post("/events")
                .then()
                .statusCode(200);

        // Read operation
        given()
                .auth()
                .basic("user", "123")
                .when()
                .get("/events")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("content", hasSize(1)); // Assuming one event was created

        // Delete operation
        given()
                .auth()
                .basic("user", "123")
                .when()
                .delete("/events/1") // Assuming the ID of the event is 1
                .then()
                .statusCode(200);

//        // Update operation
//        EventPayload updatedEventPayload = new EventPayload("Updated Event Name", "Updated Description",  AccountType.ATTENDANCE_POINTS);
//        // Perform a PUT request to update the event with the given ID
//        given()
//                .auth()
//                .basic("user", "123")
//                .contentType(ContentType.JSON)
//                .body(updatedEventPayload)
//                .when().put("/events/" + id) // Use the extracted eventId to specify the event to update
//                .then()
//                .statusCode(200); // 200 OK status code expected
//
//        // Verify that the event was updated
//        given()
//                .auth()
//                .basic("user", "123")
//                .when()
//                .get("/events/" + id) // Use the same eventId to retrieve the updated event
//                .then()
//                .statusCode(200)
//                .body("name", equalTo("Updated Event Name")) // Verify that the name was updated
//                .body("description", equalTo("Updated Description")) // Verify that the description was updated
//                .body("accountType", equalTo( AccountType.ATTENDANCE_POINTS.name())); // Verify that the accountType was updated
   // }
    }
}
