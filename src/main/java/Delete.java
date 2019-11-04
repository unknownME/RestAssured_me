package main.java;

import files.PayLoad;
import files.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Delete {

    private Properties prop;

    @BeforeTest
    public void getData() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/files/env.properties");
//      FileInputStream fis = new FileInputStream("C:\\Users\\Volodymyr_Kryvobok\\IdeaProjects\\first\\src\\main\\java\\files\\env.properties");
        prop = new Properties();
        prop.load(fis);
    }

    @Test
    public void postAndDelete() {
        RestAssured.baseURI = prop.getProperty("HOST");
        Response res =
                given().
                        queryParam("key", prop.getProperty("KEY")).
                        body(PayLoad.getPostData()).when().
                        post("/maps/api/place/add/json").
                        then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                        body("status", equalTo("OK")).extract().response();

        final String responceString = res.asString();
        System.out.println(responceString);
        JsonPath js = new JsonPath(responceString);
        final String placeId = js.get("place_id");

        //delete just added
        given().
                queryParam("key", "qaclick123").
                body("{\"place_id\":\"" + placeId + "\"}")
                .when().post(Resources.placePostData()).
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status", equalTo("OK"));

    }

}
