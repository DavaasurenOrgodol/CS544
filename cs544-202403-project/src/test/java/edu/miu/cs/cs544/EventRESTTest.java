package edu.miu.cs.cs544;

import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.service.contract.EventPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class EventRESTTest {
    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/badge-system";
    }

    @Test
    public void testEvent() {

//
//        given()
//                .contentType("application/json")
//                .body(location)
//                .when().post("/locations").then()
//                .statusCode(200);
//        //add the event to be fetched
//        Event event = new Event("CS544", "EA",AccountType.ATTENDANCE_POINTS, LocalDateTime.now(),LocalDateTime.now());
//        event.addSchedule(new Session(LocalTime.now(),LocalTime.now()));
//        given()
//                .contentType("application/json")
//                .body(event)
//                .when().post("/events").then()
//                .statusCode(200);
        // test getting the events
//		given()
//				.when()
//				.get("events")
//				.then()
//				.contentType(ContentType.JSON)
//				.and()
//				.body("events",hasSize(2));
        // add the scanner to be fetched
        EventPayload eventPayload = new EventPayload();
        given()
                .auth()
                .basic("user", "123")
                .contentType("application/json")
                .body(eventPayload)
                .when().post("/scanners").then()
                .statusCode(200);
        // test getting the events
        given()
                .auth()
                .basic("user", "123")
                .when()
                .get("scanners")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("content",hasSize(1));
        //cleanup
        given()
                .auth()
                .basic("user", "123")
                .when()
                .delete("/scanners/1")
                .then()
                .statusCode(200);
//		given()
//				.when()
//				.delete("/events/1")
//				.then()
//				.statusCode(200);
//		given()
//				.body(location)
//				.when()
//				.delete("/locations/1")
//				.then()
//				.statusCode(200);
    }
}
