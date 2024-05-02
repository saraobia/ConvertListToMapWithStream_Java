package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertListToMap implements StreamListToMap {
    private Map<String, Book> mpBooks;

    @Override
    public Map<String, Book> listToMapOldStyle(List<Book> list) {
        mpBooks = new HashMap<>();
        for (Book book : list) {
            if(!mpBooks.containsKey(book.getIsbn())) {
            Book bookWithoutIsbn = new Book(book.getDescription(), book.getAuthor(), book.getNation(), book.getPrice());
            mpBooks.put(book.getIsbn(), bookWithoutIsbn);
            }
        }
        return mpBooks;
    }

    @Override
    public Map<String, Book> listToMapWithLambda(List<Book> list) {
        return list.stream().collect(Collectors.toMap(Book::getIsbn, Function.identity()));
    }

    @Override
    public Map<String, Book> listToMapWithReference(List<Book> list) {
        return Map.of();
    }

    @Override
    public Map<String, Book> listToMapWithFunctionIdentity(List<Book> list) {
        return Map.of();
    }

    @Override
    public Map<String, List<Book>> listToMapWithNoDuplicatesList(List<Book> list) {
        return Map.of();
    }

    @Override
    public Map<String, Book> listToMapWithNoDuplicates(List<Book> list) {
        return Map.of();
    }

    @Override
    public Map<String, List<Book>> listToMapIsbnGreaterThen(List<Book> books, String isbn) {
        return Map.of();
    }

    @Override
    public Map<Boolean, List<Book>> listToMapPriceGreaterThen(List<Book> books, int price) {
        return Map.of();
    }

    @Override
    public String bookNamesJoined(List<Book> books) {
        return "";
    }

    @Override
    public double averageBookPrize(List<Book> books) {
        return 0;
    }

    @Override
    public int totalCost(List<Book> books) {
        return 0;
    }

    @Override
    public IntSummaryStatistics booksStatistics(List<Book> books) {
        return null;
    }

    @Override
    public String[] booksAuthors(List<Book> books) {
        return new String[0];
    }

    @Override
    public String[] booksAuthors(List<Book> books, String nazione) {
        return new String[0];
    }
}
