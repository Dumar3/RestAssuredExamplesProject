package pojopractice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.Utilities;
import io.restassured.specification.RequestSpecification;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import pojopractice.pojos.AddPlaceRequest;
import pojopractice.pojos.AddPlaceResponse;
import pojopractice.pojos.Location;

public class AddPlacePojoTest {

  @Test
  public void postTest() {
    RequestSpecification request = given().log().all().spec(Utilities.getRequestSpecification())
        .body(addPlaceRequestFactory());
    AddPlaceResponse addPlaceResponse = request
        .when()
        .post("/maps/api/place/add/json")
        .then().log().all()
        .spec(Utilities.getResponseSpecification())
        .body("status", equalTo("OK")).extract().as(AddPlaceResponse.class);
    System.out.println("Id Pojo: " + addPlaceResponse.getId());
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
