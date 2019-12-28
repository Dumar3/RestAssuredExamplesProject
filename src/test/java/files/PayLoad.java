package files;

public class PayLoad {

  public static String getAddBody() {
    return "{\n"
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
        + "}";
  }

  public static String getDeleteBody(String placeId) {
    return "{\n"
        + "    \"place_id\":\"" + placeId + "\"\n"
        + "}";
  }

  public static String getAddBookBody(String isbn, String aisle) {
    return "{\n"
        + "\t\"name\":\"Learn Appium Automation with Java\",\n"
        + "\t\"isbn\":\"" + isbn + "\",\n"
        + "\t\"aisle\":\"" + aisle + "\",\n"
        + "\t\"author\":\"John foe\"\n"
        + "}\n";
  }

}
