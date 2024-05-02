package convertListToMap;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ConvertListToMapTest {
    static ConvertListToMap cltm = new ConvertListToMap();

    @Test
    void testListToMapOldStyle() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));

        Map<String, Book> mpExpected = new HashMap<>();
        mpExpected.put("ISBN4567", new Book(null, "Book1", "description", "J.L. Author", "England", 23));
        mpExpected.put("ISBN5678", new Book(null, "Book2", "This is a new description", "Lauren Wolf", "France", 27));
        String expected = mpExpected.toString();

        Map<String, Book> mpActual = cltm.listToMapOldStyle(listOfBook);
        String actual = mpActual.toString();

        assertEquals(expected, actual);
    }


    @Test
    void testListToMapWithLambda() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));

        Map<String, Book> expected = cltm.listToMapWithLambda(listOfBook);
        assertNotNull(expected);

        assertEquals(2, expected.size());

        assertTrue(expected.containsKey("ISBN4567"));
        assertTrue(expected.containsKey("ISBN5678"));

        assertEquals("Book2", expected.get("ISBN5678").getName());
        assertEquals("description", expected.get("ISBN4567").getDescription());
        assertEquals("J.L. Author", expected.get("ISBN4567").getAuthor());
        assertEquals("England", expected.get("ISBN4567").getNation());
        assertEquals(23, expected.get("ISBN4567").getPrice());

        assertEquals("This is a new description", expected.get("ISBN5678").getDescription());
        assertEquals("Lauren Wolf", expected.get("ISBN5678").getAuthor());
        assertEquals("France", expected.get("ISBN5678").getNation());
        assertEquals(27, expected.get("ISBN5678").getPrice());
    }

    @Test
    void testListToMapWithReference() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));

        Map<String, Book> expected = cltm.listToMapWithReference(listOfBook);
        assertNotNull(expected);

        assertEquals(2, expected.size());

        assertTrue(expected.containsKey("ISBN4567"));
        assertTrue(expected.containsKey("ISBN5678"));

        assertEquals("Book2", expected.get("ISBN5678").getName());
        assertEquals("description", expected.get("ISBN4567").getDescription());
        assertEquals("J.L. Author", expected.get("ISBN4567").getAuthor());
        assertEquals("England", expected.get("ISBN4567").getNation());
        assertEquals(23, expected.get("ISBN4567").getPrice());

        assertEquals("This is a new description", expected.get("ISBN5678").getDescription());
        assertEquals("Lauren Wolf", expected.get("ISBN5678").getAuthor());
        assertEquals("France", expected.get("ISBN5678").getNation());
        assertEquals(27, expected.get("ISBN5678").getPrice());
    }

    @Test
    void testListToMapWithFunctionIdentity() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));

        Map<String, Book> expected = cltm.listToMapWithFunctionIdentity(listOfBook);
        assertNotNull(expected);

        assertEquals(2, expected.size());

        assertTrue(expected.containsKey("ISBN4567"));
        assertTrue(expected.containsKey("ISBN5678"));

        assertEquals("Book2", expected.get("ISBN5678").getName());
        assertEquals("description", expected.get("ISBN4567").getDescription());
        assertEquals("J.L. Author", expected.get("ISBN4567").getAuthor());
        assertEquals("England", expected.get("ISBN4567").getNation());
        assertEquals(23, expected.get("ISBN4567").getPrice());

        assertEquals("This is a new description", expected.get("ISBN5678").getDescription());
        assertEquals("Lauren Wolf", expected.get("ISBN5678").getAuthor());
        assertEquals("France", expected.get("ISBN5678").getNation());
        assertEquals(27, expected.get("ISBN5678").getPrice());
    }

    @Test
    void listToMapWithNoDuplicatesList() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "New Author", "France", 27));

        Map<String, List<Book>> expected = cltm.listToMapWithNoDuplicatesList(listOfBook);

        assertNotEquals(3, expected.size());
        assertEquals(2, expected.size());
        assertEquals(2, expected.get("ISBN4567").size());
        assertEquals(3, expected.get("ISBN5678").size());

    }

    @Test
    void listToMapWithNoDuplicates() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "New Author", "France", 27));

        Map<String, Book> expected = cltm.listToMapWithNoDuplicates(listOfBook);

        assertNotEquals(3, expected.size());
        assertEquals(2, expected.size());
    }

    @Test
    void listToMapIsbnGreaterThen() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));
        listOfBook.add(new Book("ISBN5698", "Book3", "New description", "Christian", "Italy", 17));
        listOfBook.add(new Book("ISBN5786", "Book3", "Fourth Description", "K.L.", "USA", 19));

        Map<String, Book> mpExpected = new HashMap<>();
        mpExpected.put("ISBN5678", new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));
        mpExpected.put("ISBN5786", new Book("ISBN5786", "Book3", "Fourth Description", "K.L.", "USA", 19));
        mpExpected.put("ISBN5698", new Book("ISBN5698", "Book3", "New description", "Christian", "Italy", 17));

        Map<String, List<Book>> mpActual = cltm.listToMapIsbnGreaterThen(listOfBook, "ISBN4567");
        Map<String, List<Book>> expected = new HashMap<>();
        mpExpected.forEach((isbn, book) -> expected.put(isbn, Collections.singletonList(book)));

        assertEquals(expected, mpActual);

    }

    @Test
    void listToMapPriceGreaterThen() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));
        listOfBook.add(new Book("ISBN5786", "Book3", "Fourth Description", "K.L.", "USA", 19));


        Map<Boolean, List<Book>> mpActual = cltm.listToMapPriceGreaterThen(listOfBook, 23);

        Map<Boolean, List<Book>> mpExpected = new HashMap<>();
        mpExpected.put(true, Collections.singletonList(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27)));
        mpExpected.put(false, Collections.singletonList(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23)));
        mpExpected.put(false, Collections.singletonList(new Book("ISBN5786", "Book3", "Fourth Description", "K.L.", "USA", 19)));


    }

    @Test
    void bookNamesJoined() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));
        listOfBook.add(new Book("ISBN5698", "Book3", "New description", "Christian", "Italy", 17));
        listOfBook.add(new Book("ISBN5786", "Book4", "Fourth Description", "K.L.", "USA", 19));

        String actual = cltm.bookNamesJoined(listOfBook);
        String expected = "Book1, Book2, Book3, Book4";

        assertEquals(expected, actual);
    }

    @Test
    void testAverageBookPrize() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));
        listOfBook.add(new Book("ISBN5698", "Book3", "New description", "Christian", "Italy", 17));
        listOfBook.add(new Book("ISBN5786", "Book4", "Fourth Description", "K.L.", "USA", 19));

        Double actual = cltm.averageBookPrize(listOfBook);
        Double expected = 21.5;

        assertEquals(expected, actual);
    }

    @Test
    void totalCost() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));
        listOfBook.add(new Book("ISBN5698", "Book3", "New description", "Christian", "Italy", 17));
        listOfBook.add(new Book("ISBN5786", "Book4", "Fourth Description", "K.L.", "USA", 19));

        int actual = cltm.totalCost(listOfBook);
        int expected = 86;

        assertEquals(expected, actual);
    }

    @Test
    void booksStatistics() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));
        listOfBook.add(new Book("ISBN5698", "Book3", "New description", "Christian", "Italy", 17));
        listOfBook.add(new Book("ISBN5786", "Book4", "Fourth Description", "K.L.", "USA", 19));

        IntSummaryStatistics stats = cltm.booksStatistics(listOfBook);

        assertEquals(4, stats.getCount());
        assertEquals(86, stats.getSum());
        assertEquals(21.5, stats.getAverage());
        assertEquals(17, stats.getMin());
        assertEquals(27, stats.getMax());
    }

    @Test
    void booksAuthors() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Bill", "England", 23));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));
        listOfBook.add(new Book("ISBN5698", "Book3", "New description", "Christian F.", "Italy", 17));
        listOfBook.add(new Book("ISBN5786", "Book4", "Fourth Description", "K.L.", "USA", 19));

        String[] actual = cltm.booksAuthors(listOfBook);
        String[] expected = {
                "J.L. Bill",
                "Lauren Wolf",
                "Christian F.",
                "K.L."
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void testBooksAuthors() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "Book1", "description", "J.L. Bill", "England", 23));
        listOfBook.add(new Book("ISBN5678", "Book2", "This is a new description", "Lauren Wolf", "France", 27));
        listOfBook.add(new Book("ISBN5698", "Book3", "New description", "Christian F.", "Italy", 17));
        listOfBook.add(new Book("ISBN5786", "Book4", "Fourth Description", "K.L.", "USA", 19));
        listOfBook.add(new Book("ISBN5786", "Book4", "Other Description", "Jim brown", "USA", 19));
        listOfBook.add(new Book("ISBN5786", "Book4", "Fourth Description", "Billy Smith", "USA", 29));

        String[] actual = cltm.booksAuthors(listOfBook, "USA");
        String[] expected = {
                "K.L.",
                "Jim brown",
                "Billy Smith"
        };

        assertArrayEquals(expected, actual);
    }
}