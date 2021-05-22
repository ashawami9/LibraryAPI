import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import requests.AddBook;
import requests.FindBook;

import static org.junit.Assert.assertEquals;

public class FindBookTest extends BaseTest {
    @BeforeTest
    public void setup() {
        InitialSetup();
    }

    @Test
    public void testFindBookById() {
        AddBook add = new AddBook();
        String id = add.newBook(get.newBook()).jsonPath().getString("ID");
        FindBook book = new FindBook();
        Response response = book.retrieve("ID", id);
        assertEquals(200, response.statusCode());
        assertEquals("Use Mac", response.jsonPath().getString("book_name[0]"));
    }

    @Test
    public void testFindBookByAuthorName() {
        AddBook add = new AddBook();
        String id = add.newBook(get.newBook()).jsonPath().getString("ID");
        FindBook book = new FindBook();
        Response responseBook = book.retrieve("ID", id);
        Response response = book.retrieve("AuthorName", responseBook.jsonPath().getString("author[0]"));
        assertEquals("Learn Appium Automation with Java", response.jsonPath().getString("book_name[0]"));
    }
}
