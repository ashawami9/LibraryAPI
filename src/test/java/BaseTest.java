import io.restassured.RestAssured;

import payload.BookPayload;

public class BaseTest {
    public BookPayload get = new BookPayload();

    public void InitialSetup() {
        RestAssured.baseURI = "http://216.10.245.166";
    }
}

