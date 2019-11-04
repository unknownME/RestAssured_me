package main.java;

import files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StaticJson {

    @Test(dataProvider = "BooksData")
    public void test(String isbn, String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";
        Response r = given().
                header("Content-Type", "application/json").
                body(PayLoad.addBook(isbn, aisle)).
                when().
                post("/Library/Addbook.php")
                .then().assertThat().statusCode(200).extract().response();
//        JsonPath js = ReusableMethods.rawToJSON(r);
//        System.out.println(js.get("ID"));

    }

    @DataProvider(name = "BooksData")
    public Object[][] getData() {
        return new Object[][]{{"asdfa1", "9991"}, {"asdfs1", "8881"}, {"asdfd1", "7771"}};
    }

}
