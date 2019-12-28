package practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class GetPlaceGoogleMapsTest {

  @Test
  //public static void main(String[] args) {
  public void getTest() {

    //BaseURL or Host
    RestAssured.baseURI = "https://maps.googleapis.com";

    given()
        .param("location", "-33.8670522,151.1957362")
        .param("radius", "1500")
        .param("key", "AIzaSyAqbb68YgCPhjP6tdoHAyv35TBEVEP6nVc")
        .when()
        .get("/maps/api/place/nearbysearch/json")
        .then()
        .assertThat()
        .statusCode(200)
        .and().contentType(ContentType.JSON)
        .and().header("Server", "scaffolding on HTTPServer2");
    //.and().body("results[0].name", equalTo("Sydney"));

  }

}
