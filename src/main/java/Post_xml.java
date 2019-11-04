package main.java;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.*;
import static io.restassured.RestAssured.given;

public class Post_xml {

    @Test
    public void postMethod() throws IOException {
        String a = generateStringFromResource("C:\\Users\\Volodymyr_Kryvobok\\IdeaProjects\\first\\src\\main\\java\\files\\postdata.xml");
        RestAssured.baseURI = "http://216.10.245.166";
        Response r =
        given().
                queryParam("key", "qaclick123").
                body(a).when().
                post("/maps/api/place/add/xml").
                then().assertThat().statusCode(200).and().contentType(ContentType.XML).extract().response();
        XmlPath x = ReusableMethods.rawToXML(r);
        System.out.println(x.get("responce.place_id"));
    }

    public static String generateStringFromResource(String path) throws IOException {
        File xmlFile = new File(path);
        Reader fileReader = new FileReader(xmlFile);
        BufferedReader bufReader = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();
        String line = bufReader.readLine();
        while( line != null){
            sb.append(line).append("\n");
            line = bufReader.readLine();
        }
        String xml2String = sb.toString();
        return xml2String;

    }

}
