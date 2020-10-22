package osr.monsterGenerator.restTests;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SystemsControllerTest {

    @Test
    public void getAllSystems_200() {
        given().when().get("http://localhost:8080/api/systems").then().assertThat().statusCode(200);
    }

    @Test
    public void getAllSystems_() {
        given().when().get("http://localhost:8080/api/systems").then().assertThat().statusCode(200);
    }
}
