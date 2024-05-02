package org.example;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

public interface StreamListToMap {
    Map<String, Book> listToMapOldStyle(List<Book> list) ;
    Map<String, Book> listToMapWithLambda(List<Book> list) ;

    Map<String, Book> listToMapWithReference(List<Book> list) ;

    Map<String, Book> listToMapWithFunctionIdentity(List<Book> list) ;

    Map<String, List<Book>> listToMapWithNoDuplicatesList(List<Book> list) ;

    Map<String, Book> listToMapWithNoDuplicates(List<Book> list) ;

    Map<String, List<Book>> listToMapIsbnGreaterThen(List<Book> books, String isbn) ;

    Map<Boolean, List<Book>> listToMapPriceGreaterThen(List<Book> books, int price) ;

    String bookNamesJoined(List<Book> books) ;

    double averageBookPrize(List<Book> books) ;

    int totalCost(List<Book> books) ;

    IntSummaryStatistics booksStatistics(List<Book> books) ;

    String[] booksAuthors(List<Book> books) ;

    String[] booksAuthors(List<Book> books, String nazione) ;
}


