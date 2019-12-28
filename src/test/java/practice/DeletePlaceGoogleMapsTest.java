package practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.PayLoad;
import files.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;

public class DeletePlaceGoogleMapsTest {

  private Properties properties = new Properties();

  @Before
  public void getData() throws IOException {
    FileInputStream fileInputStream = new FileInputStream("gradle.properties");
    properties.load(fileInputStream);
  }

  @Test
  public void postTest() {
    RestAssured.baseURI = properties.getProperty("HOST");
    Response response = given()
        .queryParam("key", "qaclick123")
        .body(PayLoad.getAddBody())
        .when()
        .post(Resources.getAddPlacePostDataResource())
        .then()
        .assertThat()
        .statusCode(200)
        .and().contentType(ContentType.JSON)
        .and().body("status", equalTo("OK"))
        .extract().response();
    String responseString = response.asString();
    System.out.println("Add Response: " + responseString);
    JsonPath jsonPath = new JsonPath(responseString);
    String placeId = jsonPath.get("place_id");
    System.out.println("Place id: " + placeId);

    Response deleteResponse = given()
        .queryParam("key", "qaclick123")
        .body(PayLoad.getDeleteBody(placeId))
        .when()
        .post(Resources.getDeleteplacePostDataResource())
        .then()
        .assertThat()
        .statusCode(200)
        .and().contentType(ContentType.JSON)
        .and().body("status", equalTo("OK"))
        .extract().response();

    String deleteResponseString = deleteResponse.asString();
    System.out.println("Delete Response: " + deleteResponseString);

  }

}
