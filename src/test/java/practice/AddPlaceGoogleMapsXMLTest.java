package practice;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import java.io.IOException;
import org.junit.Test;
import files.Utilities;

public class AddPlaceGoogleMapsXMLTest {

  @Test
  //public static void main(String[] args) {
  public void addPlaceXmlPostTest() throws IOException {
    //BaseURL or Host
    RestAssured.baseURI = "http://216.10.245.166";
    String postData = Utilities.generateStringFromResource("D:\\Courses\\Udemy\\Projects\\RestAssuredProject\\src\\test\\java\\files\\xmladdplacepostdata.xml");
    Response response = given()
        .queryParam("key", "qaclick123")
        .body(postData)
        .log().all()
        .when()
        .post("/maps/api/place/add/xml")
        .then()
        .log().body()
        .assertThat()
        .statusCode(200)
        .and().contentType(ContentType.XML)
        .extract().response();
    System.out.println("Place id: " + Utilities.convertResponseXml(response).get("response.place_id"));
  }

}
