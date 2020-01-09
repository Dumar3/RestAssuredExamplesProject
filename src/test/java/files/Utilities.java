package files;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utilities {

  public static String generateStringFromResource(String path) throws IOException {
    return new String(Files.readAllBytes(Paths.get(path)));
  }

  public static XmlPath convertResponseXml(Response response){
    String stringResponse = response.asString();
    return new XmlPath(stringResponse);
  }

  public static JsonPath convertResponseJson(Response response){
    String stringResponse = response.asString();
    return new JsonPath(stringResponse);
  }

  public static RequestSpecification getRequestSpecification(){
    return new RequestSpecBuilder()
        .setBaseUri("http://216.10.245.166")
        .addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
  }

  public static ResponseSpecification getResponseSpecification(){
    return new ResponseSpecBuilder().expectStatusCode(200)
        .expectContentType(ContentType.JSON).build();
  }

}
