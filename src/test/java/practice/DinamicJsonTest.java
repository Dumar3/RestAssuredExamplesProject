package practice;

import static io.restassured.RestAssured.given;

import files.PayLoad;
import files.Utilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DinamicJsonTest {

  @Test(dataProvider="BookData")
  public void addBookTest(String isbn, String aisle) {
    RestAssured.baseURI = "http://216.10.245.166";
    Response response = given()
        .header("Content-Type", "application/json")
        .body(PayLoad.getAddBookBody(isbn, aisle))
        .when()
        .post("/Library/Addbook.php")
        .then()
        .log().body()
        .assertThat()
        .statusCode(200)
        .and().contentType(ContentType.JSON)
        .extract().response();
    JsonPath jsonPath = Utilities.convertResponseJson(response);
    System.out.println("Response: "+response);
    System.out.println("Response: "+response.asString());
    System.out.println("Response: "+jsonPath.get("ID"));
  }

  @DataProvider(name="BookData")
  public Object [][] getBookData(){
    return new Object[][] {{"sdfff","8432"}, {"serff","8409"}, {"slsof","8322"}};
  }

}
