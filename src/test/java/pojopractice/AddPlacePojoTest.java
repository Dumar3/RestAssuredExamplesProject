package practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class AddPlaceGoogleMapsTest {

  @Test
  //public static void main(String[] args) {
  public void postTest() {

    //BaseURL or Host
    RestAssured.baseURI = "http://216.10.245.166";

    given()

        .queryParam("key", "qaclick123")
        .body("{\n"
            + "\t\"location\": {\n"
            + "\t\t\"lat\": -38.383494,\n"
            + "\t\t\"lng\": 33.427362\n"
            + "\t},\n"
            + "\t\"accuracy\": 50,\n"
            + "\t\"name\": \"Frontline house\",\n"
            + "\t\"phone_number\": \"(+91) 983 893 3937\",\n"
            + "\t\"address\": \"29, side layout, cohen 09\",\n"
            + "\t\"types\": [\"shoe park\", \"shop\"],\n"
            + "\t\"website\": \"http://google.com\",\n"
            + "\t\"language\": \"French-IN\"\n"
            + "}")
        .when()
        .post("/maps/api/place/add/json")
        .then()
        .assertThat()
        .statusCode(200)
        .and().contentType(ContentType.JSON)
        .and().body("status", equalTo("OK"));
  }

}
