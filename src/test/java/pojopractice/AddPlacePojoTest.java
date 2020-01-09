package pojopractice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.Utilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import pojopractice.pojos.AddPlaceRequest;
import pojopractice.pojos.AddPlaceResponse;
import pojopractice.pojos.Location;

public class AddPlacePojoTest {

  @Test
  //public static void main(String[] args) {
  public void postTest() {

    //BaseURL or Host
    RestAssured.baseURI = "http://216.10.245.166";

    AddPlaceResponse addPlaceResponse = new AddPlaceResponse();
    addPlaceResponse = given().log().all()
        .queryParam("key", "qaclick123")
        .header("Content-Type", "application/json")
        .body(addPlaceRequestFactory())
        .when()
        .post("/maps/api/place/add/json")
        .then().log().all()
        .assertThat()
        .statusCode(200)
        .and().contentType(ContentType.JSON)
        .and().body("status", equalTo("OK")).extract().as(AddPlaceResponse.class);
    System.out.println("Id Pojo: " + addPlaceResponse.getId());
    //JsonPath jp = Utilities.convertResponseJson(response);
    //System.out.println("Response: " + response);
    //System.out.println("Response as string: " + response.asString());
    //System.out.println("Id JsonPath: " + jp.get("id"));
  }

  AddPlaceRequest addPlaceRequestFactory() {
    AddPlaceRequest addPlaceRequest = new AddPlaceRequest();
    List<String> lstTypes = new ArrayList<>();
    lstTypes.add("shoe park");
    lstTypes.add("shop");
    addPlaceRequest.setLocation(locationFactory());
    addPlaceRequest.setAccuracy(50);
    addPlaceRequest.setName("Frontline house");
    addPlaceRequest.setPhoneNumber("(+91) 983 893 3937");
    addPlaceRequest.setAddress("29, side layout, cohen 09");
    addPlaceRequest.setTypes(lstTypes);
    addPlaceRequest.setWebsite("http://google.com");
    addPlaceRequest.setLanguage("French-IN");
    return addPlaceRequest;
  }

  private Location locationFactory() {
    Location location = new Location();
    location.setLat(-38.383494f);
    location.setLng(33.427362f);
    return location;
  }

}
