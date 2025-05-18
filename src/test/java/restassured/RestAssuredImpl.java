package restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredImpl {
    String token;
    
    @Test()
    public void testLogin(){
        /*
         * Define the base URL for the API
         * String baseUrl = "https://whitesmokehouse.com";
         */
        RestAssured.baseURI = "https://whitesmokehouse.com";

        // Create login request
        String requestBody = "{\n" + //
                        "  \"email\": \"albertsimanjuntak12@gmail.com\",\n" + //
                        "  \"password\": \"@dmin123\"\n" + //
                        "}";
        // Send POST request to login endpoint
        Response response = RestAssured.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .log().all()
                .when()
                .post("/webhook/api/login");
        // Print the response
        // token = response.jsonPath().getString("[0].token");  
        // System.out.println("Token: " + token); 
        token = response.jsonPath().getString("token");  
        System.out.println("Response: " + response.asPrettyString());     
    }

    @Test(dependsOnMethods = "testLogin")
    public void testGetAllObject(){
        /*
         * Define the base URL for the API
         * String baseUrl = "https://whitesmokehouse.com";
         */
        RestAssured.baseURI = "https://whitesmokehouse.com";
        // Create Get Employee request
        // Send GET request to employee endpoint
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .log().all()
                .when()
                .get("/webhook/api/objects");
        // Print the response
        System.out.println("Response: " + response.asPrettyString());
        // Validate the response
        // Assert.assertEquals(response.getStatusCode(), 200);
        assert response.getStatusCode() == 200 : "Expected status code 200 but got " + response.getStatusCode();
    }
        
    @Test
    public void testListAllObjectsByIds(){
        /*
         * Define the base URL for the API
         * String baseUrl = "https://whitesmokehouse.com";
         */
        RestAssured.baseURI = "https://whitesmokehouse.com";
        // Create Get All Object request
        // Send GET request to Object endpoint
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .log().all()
                .when()
                .get("/webhook/api/objects?id=3");
        // Print the response
        System.out.println("Response: " + response.asPrettyString());
    }

    @Test
    public void testSingleObject(){
        /*
         * Define the base URL for the API
         * String baseUrl = "https://whitesmokehouse.com";
         */
        RestAssured.baseURI = "https://whitesmokehouse.com";
        // Create Get All Object request
        // Send GET request to Object endpoint
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .log().all()
                .when()
                .get("/webhook/8749129e-f5f7-4ae6-9b03-93be7252443c/api/objects/12");
        // Print the response
        System.out.println("Response: " + response.asPrettyString());
    }

    @Test(dependsOnMethods = "testLogin", priority = 1)
    public void testAddObject(){
        /*
         * Define the base URL for the API
         * String baseUrl = "https://whitesmokehouse.com";
         */
        RestAssured.baseURI = "https://whitesmokehouse.com";
        // Create Create Employee request
        String bodyCreate = "{\n" +
                "  \"name\": \"Apple MacBook Pro 16\",\n" +
                "  \"data\": {\n" +
                "    \"year\": 2019,\n" +
                "    \"price\": 1849.99,\n" +
                "    \"cpu_model\": \"Intel Core i9\",\n" +
                "    \"hard_disk_size\": \"1 TB\",\n" +
                "    \"capacity\": \"2 cpu\",\n" +
                "    \"screen_size\": \"14 Inch\",\n" +
                "    \"color\": \"red\"\n" +
                "  }\n" +
                "}";

        // Send POST request to employee endpoint
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(bodyCreate)
                .log().all()
                .when()
                .post("/webhook/api/objects");

        System.out.println("Response: " + response.asPrettyString());
    }

    @Test(dependsOnMethods = "testLogin", priority = 2)
    public void testUpdateObject(){
        /*
         * Define the base URL for the API
         * String baseUrl = "https://whitesmokehouse.com";
         */
        RestAssured.baseURI = "https://whitesmokehouse.com";
        // Create Update Employee request
        String bodyUpdate = "{\n" +
                    "    \"year\": \"2019\",\n" +
                    "    \"price\": 1849.99,\n" +
                    "    \"cpu_model\": \"Intel Core i9\",\n" +
                    "    \"hard_disk_size\": \"1 TB\",\n" +
                    "    \"capacity\": \"2 cpu\",\n" +
                    "    \"screen_size\": \"14 Inch\",\n" +
                    "    \"color\": \"red\",\n" +
                    "}";
                         
        // Send POST request to Object endpoint
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(bodyUpdate)
                .log().all()
                .when()
                .put("/webhook/37777abe-a5ef-4570-a383-c99b5f5f7906/api/objects/3");

        System.out.println("Response: " + response.asPrettyString());
    }

    @Test(dependsOnMethods = "testLogin", priority = 3)
    public void testDeleteObject(){
        /*
         * Define the base URL for the API
         * String baseUrl = "https://whitesmokehouse.com";
         */
        RestAssured.baseURI = "https://whitesmokehouse.com";
        // Create Delete Object request
        // Send DELETE request to Object endpoint
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .log().all()
                .when()
                .delete("/webhook/d79a30ed-1066-48b6-83f5-556120afc46f/api/objects/3");
        // Print the response
        System.out.println("Response: " + response.asPrettyString());
    }

    @Test
    public void testGetAllDepartment(){
        /*
         * Define the base URL for the API
         * String baseUrl = "https://whitesmokehouse.com";
         */
        RestAssured.baseURI = "https://whitesmokehouse.com";
        // Create Get All Object request
        // Send GET request to Object endpoint
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .log().all()
                .when()
                .get("/webhook/api/department");
        // Print the response
        System.out.println("Response: " + response.asPrettyString());
    }

    @Test(dependsOnMethods = "testLogin" , priority = 4)
    public void testPartiallyUpdateObject(){
        /*
         * Define the base URL for the API
         * String baseUrl = "https://whitesmokehouse.com";
         */
        RestAssured.baseURI = "https://whitesmokehouse.com";
        // Create Update Employee request
        String bodyUpdate = "{\n" +
                "  \"name\": \"Apple MacBook Pro 1611-albert12\",\n" +
                "  \"year\": \"2030\"\n" +
                "}";
        // Send PATCH request to Object endpoint
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .log().all()
                .when()
                .patch("/webhook/39a0f904-b0f2-4428-80a3-391cea5d7d04/api/object/12");
        // Print the response
        System.out.println("Response: " + response.asPrettyString());
    }

    // @Test
    // public void getObjectInvalidToken(){
    //     /*
    //      * Define the base URL for the API
    //      * String baseUrl = "https://whitesmokehouse.com";
    //      */
    //     RestAssured.baseURI = "https://whitesmokehouse.com";
    //     // Create Get Object request
    //     // Send GET request to employee endpoint
    //     Response response = RestAssured.given()
    //             .header("Content-Type", "application/json")
    //             .header("Authorization", "Bearer " + token + "invalid")
    //             .log().all()
    //             .when()
    //             .get("/webhook/api/get");
    //     // Print the response
    //     System.out.println("Response: " + response.asPrettyString());

    //     // Validate the response
    //     assert response.getStatusCode() == 403 : "Expected status code 403 but got " + response.getStatusCode();
        
    // }
}
