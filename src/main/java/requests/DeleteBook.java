package requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBook {
    public Response delete(String id) {
        String deleteId = "{\n" +
                "    \"ID\":" + id + "\n" +
                "}";

        Response response = given()
                .header("Content-type", "application/json")
                .body(deleteId)
                .and()
                .delete("/Library/DeleteBook.php")
                .then()
                .extract().response();
        return response;
    }
}
