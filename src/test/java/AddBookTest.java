import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import requests.AddBook;

import static org.testng.Assert.assertEquals;

public class AddBookTest extends BaseTest {
    @BeforeTest
    public void setup() {
        InitialSetup();
    }

    @Test
    public void testAddNewBook() {
        AddBook add = new AddBook();
        Response response = add.newBook(get.newBook());
        assertEquals(200, response.statusCode());
        assertEquals("successfully added", response.jsonPath().getString("Msg"));
    }

    @Test
    public void testAddAlreadyExistingBook() {
        AddBook add = new AddBook();
        Response response = add.newBook(get.alreadyExistingBook());
        assertEquals(404, response.statusCode());
        assertEquals("Add Book operation failed, looks like the book already exists", response.jsonPath().getString("msg"));
    }
}
