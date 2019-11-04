package files;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.path.xml.XmlPath;

public class ReusableMethods {

    public static XmlPath rawToXML(Response r) {
        String response = r.asString();
        XmlPath xml = new XmlPath(response);
        return xml;
    }

    public static JsonPath rawToJSON(Response r) {
        String response = r.asString();
        System.out.println(response);
        JsonPath json = new JsonPath(response);
        return json;
    }
}
