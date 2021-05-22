import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import requests.AddBook;
import requests.DeleteBook;

import static org.junit.Assert.assertEquals;

public class DeleteBookTest extends BaseTest {
    @BeforeTest
    public void setup() {
        InitialSetup();
    }

    @Test
    public void testDeleteBook() {
        AddBook add = new AddBook();
        String id = add.newBook(get.newBook()).jsonPath().getString("ID");
        DeleteBook book = new DeleteBook();
        Response response = book.delete(id);
        assertEquals(200, response.statusCode());
        assertEquals("book is successfully deleted", response.jsonPath().getString("msg"));
    }
}
