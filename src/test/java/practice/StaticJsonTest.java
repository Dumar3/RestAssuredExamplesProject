package practice;

import static io.restassured.RestAssured.given;

import files.Utilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.IOException;
import org.junit.Test;

public class StaticJsonTest {

  @Test
  public void addBookTest() throws IOException {
    RestAssured.baseURI = "http://216.10.245.166";
    Response response = given()
        .log().all()
        .header("Content-Type", "application/json")
        .body(Utilities.generateStringFromResource(
            "D:\\Courses\\Udemy\\Projects\\RestAssuredProject\\src\\test\\java\\files\\jsonaddbookpostdata.json"))
        .when()
        .post("/Library/Addbook.php")
        .then()
        .log().body()
        .assertThat()
        .statusCode(200)
        .and().contentType(ContentType.JSON)
        .extract().response();
    JsonPath jsonPath = Utilities.convertResponseJson(response);
    System.out.println("Response: " + response);
    System.out.println("Response: " + response.asString());
    System.out.println("Response: " + jsonPath.get("ID"));
  }

}
