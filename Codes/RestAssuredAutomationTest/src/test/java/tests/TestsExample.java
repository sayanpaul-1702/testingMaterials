package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

public class TestsExample {

    String API_KEY = "pro_36e3481025caf95435a8446a9580597fa1cb15c99d4548e2eac73b7df23ce659";
    String productId = "";

    @BeforeClass
    public void setup(){
        baseURI = "https://reqres.in";
        basePath = "/api";
        useRelaxedHTTPSValidation();
    }

//    @Test(priority = 1)
//    public void getSingleUserWithId2(){
//        given()
//                .header("x-api-key",API_KEY)
//        .when()
//                .get("/users/2")
//        .then()
//                .statusCode(200)
//                .body("data.id",equalTo(2))
//                .log().all();
//
//    }

    @Test(priority = 1)
    public void postRecord(){
        String prodName = "Power Bank";
        double price = 30.79;
        String category = "Electronics";
        boolean inStock = true;
        Map<String, Object> body = Map.of(
                "data", Map.of(
                        "name", prodName,
                        "price", price,
                        "category", category,
                        "in_stock", inStock
                )
        );
        JSONObject obj = new JSONObject(body);
        ValidatableResponse res =
                given()
                    .header("x-api-key", API_KEY)
                    .contentType("application/json")
                .when()
                    .post("/collections/products/records?project_id=23147")
                .then()
                    .statusCode(201)
                    .body("data.data.name", equalTo(prodName))
                    .body("data.data.price", equalTo((float) price));
        productId = res.extract().path("data.id");
        System.out.println((String) res.extract().path("data.id"));
    }


    @Test(priority = 2, dependsOnMethods = {"postRecord"})
    public void updateRecord(){
        String prodName = "Power Bank";
        double updatedPrice = 40.79;
        String category = "Electronics";
        boolean inStock = false;
        Map<String, Object> body = Map.of(
                "data", Map.of(
                        "name", prodName,
                        "price", updatedPrice,
                        "category", category,
                        "in_stock", inStock
                )
        );
        JSONObject obj = new JSONObject(body);
        Response response = given()
                .header("x-api-key",API_KEY)
                .contentType("application/json")
                .body(obj.toJSONString())
        .when()
                .put("/collections/products/records/"+productId+"?project_id=23147")
        .then()
                .statusCode(200)
                .body("data.data.name", equalTo(prodName))
                .body("data.data.price", equalTo((float) updatedPrice))
        .extract()
        .response();

        //extract values if needed
        System.out.println("Name of product added: " + response.jsonPath().getString("data.data.name"));

    }

    @Test(priority = 3,dependsOnMethods = {"postRecord"})
    public void deleteRecord(){
                given()
                        .header("x-api-key",API_KEY)
                .when()
                        .delete("/collections/products/records/"+productId+"?project_id=23147")
                .then()
                        .statusCode(204);


    }


}
