package test;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetTest implements Serializable{

    @Test
    public void testMethod() throws IOException, ClassNotFoundException {

        RestAssured.baseURI = "https://maps.googleapis.com";
        Response res =
        given().
                param("location", "-33.8670522,151.1957362").
                param("radius", "1500").
                param("key", "AIzaSyBKZvAMF-cURylH-D4AIwzQfNY6oh8osGE").log().all().
                when().
                get("/maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("results[0].name", equalTo("Sydney")).and().
                body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
                header("Server", equalTo("scaffolding on HTTPServer2")).extract().response();

        JsonPath js = ReusableMethods.rawToJSON(res);
        int count = js.get("results.size()");
        System.out.println(count);

        String a = "aaaaabbbbcccc";
        ObjectOutputStream  oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Volodymyr_Kryvobok\\Desktop\\1.txt"));
        oos.writeObject(a);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Volodymyr_Kryvobok\\Desktop\\1.txt"));
        String b = (String) ois.readObject();
        ois.close();
        System.out.println(b);

    }

}
