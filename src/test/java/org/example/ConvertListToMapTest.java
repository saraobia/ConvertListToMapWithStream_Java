package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConvertListToMapTest {
    static ConvertListToMap cltm = new ConvertListToMap();

    @Test
    void testListToMapOldStyle() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN5678", "This is a new description", "Lauren Wolf", "France", 27));

        Map<String, Book> mpExpected = new HashMap<>();
        mpExpected.put("ISBN4567", new Book(null, "description", "J.L. Author", "England", 23));
        mpExpected.put("ISBN5678", new Book(null, "This is a new description", "Lauren Wolf", "France", 27));
        String expected = mpExpected.toString();

        Map<String, Book> mpActual = cltm.listToMapOldStyle(listOfBook);
        String actual = mpActual.toString();

        assertEquals(expected, actual);
    }


    @Test
    void testListToMapWithLambda() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book("ISBN4567", "description", "J.L. Author", "England", 23));
        listOfBook.add(new Book("ISBN5678", "This is a new description", "Lauren Wolf", "France", 27));

        Map<String, Book> result = cltm.listToMapWithLambda(listOfBook);
        assertNotNull(result);

        assertEquals(2, result.size());

        assertTrue(result.containsKey("ISBN4567"));
        assertTrue(result.containsKey("ISBN5678"));

        assertEquals("description", result.get("ISBN4567").getDescription());
        assertEquals("J.L. Author", result.get("ISBN4567").getAuthor());
        assertEquals("England", result.get("ISBN4567").getNation());
        assertEquals(23, result.get("ISBN4567").getPrice());

        assertEquals("This is a new description", result.get("ISBN5678").getDescription());
        assertEquals("Lauren Wolf", result.get("ISBN5678").getAuthor());
        assertEquals("France", result.get("ISBN5678").getNation());
        assertEquals(27, result.get("ISBN5678").getPrice());
    }

    @Test
    void listToMapWithReference() {
    }

    @Test
    void listToMapWithFunctionIdentity() {
    }

    @Test
    void listToMapWithNoDuplicatesList() {
    }

    @Test
    void listToMapWithNoDuplicates() {
    }

    @Test
    void listToMapIsbnGreaterThen() {
    }

    @Test
    void listToMapPriceGreaterThen() {
    }

    @Test
    void bookNamesJoined() {
    }

    @Test
    void averageBookPrize() {
    }

    @Test
    void totalCost() {
    }

    @Test
    void booksStatistics() {
    }

    @Test
    void booksAuthors() {
    }

    @Test
    void testBooksAuthors() {
    }
}