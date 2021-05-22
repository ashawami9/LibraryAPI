package payload;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateNewBook {
    public String generate() {
        String id = getUniqueID();
        String uniqueISBN = id.substring(0, (getUniqueID().length() / 2));
        String uniqueAisle = id.substring(getUniqueID().length() / 2);
        String newBook = "{\n" +
                "    \"name\" : \"Use Mac\",\n" +
                "    \"isbn\" : " + uniqueISBN + ",\n" +
                "    \"aisle\": " + uniqueAisle + ",\n" +
                "    \"author\": \"siri\"\n" +
                "}";
        return newBook;
    }

    private String getUniqueID() {
        String uniqueID = new SimpleDateFormat("yyyMMddHHmmssSS").format(new Date());
        return uniqueID;
    }
}
