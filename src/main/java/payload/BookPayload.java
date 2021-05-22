package payload;

public class BookPayload {
    private String author = "cloe";
    private String existingBook = "{\n" +
            "        \"name\": \"Event Bubbling\",\n" +
            "        \"isbn\": \"121223\",\n" +
            "        \"aisle\": \"4533226\",\n" +
            "        \"author\": \"Siri\"\n" +
            "    }";

    public String newBook() {
        GenerateNewBook newBook = new GenerateNewBook();
        return newBook.generate();
    }

    public String alreadyExistingBook() {
        return existingBook;
    }
}
