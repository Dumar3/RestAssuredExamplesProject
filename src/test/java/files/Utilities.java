package files;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
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

}
