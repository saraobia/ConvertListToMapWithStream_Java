package convertListToMap;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertListToMap implements StreamListToMap {
    private Map<String, Book> mpBooks;

    @Override
    public Map<String, Book> listToMapOldStyle(List<Book> list) {
        mpBooks = new HashMap<>();
        for (Book book : list) {
            if (!mpBooks.containsKey(book.getIsbn())) {
                Book bookWithoutIsbn = new Book(book.getName(), book.getDescription(), book.getAuthor(), book.getNation(), book.getPrice());
                mpBooks.put(book.getIsbn(), bookWithoutIsbn);
            }
        }
        return mpBooks;
    }

    @Override
    public Map<String, Book> listToMapWithLambda(List<Book> list) {
        return list.stream().collect(Collectors.toMap(
                b -> b.getIsbn(),
                b -> b));
    }

    @Override
    public Map<String, Book> listToMapWithReference(List<Book> list) {
        return list.stream().collect(Collectors.toMap(
                Book::getIsbn,
                b -> b));
    }

    @Override
    public Map<String, Book> listToMapWithFunctionIdentity(List<Book> list) {
        return list.stream().collect(Collectors.toMap(
                Book::getIsbn,
                Function.identity()));
    }

    @Override
    public Map<String, List<Book>> listToMapWithNoDuplicatesList(List<Book> list) {
        return list.stream().collect(Collectors.groupingBy(Book::getIsbn));
    }

    @Override
    public Map<String, Book> listToMapWithNoDuplicates(List<Book> list) {
        return list.stream().collect(Collectors.toMap(
                Book::getIsbn,
                Function.identity(),
                (existing, replacement) -> existing
        ));
    }

    @Override
    public Map<String, List<Book>> listToMapIsbnGreaterThen(List<Book> books, String isbn) {
        return books.stream().
                filter(b -> b.getIsbn().compareTo(isbn) > 0).
                collect(Collectors.groupingBy(Book::getIsbn));
    }

    @Override
    public Map<Boolean, List<Book>> listToMapPriceGreaterThen(List<Book> books, int price) {
        return books.stream().collect(Collectors.partitioningBy(b -> b.getPrice() > price));
    }

    @Override
    public String bookNamesJoined(List<Book> books) {
        return books.stream().map(Book::getName).collect(Collectors.joining(", "));
    }

    @Override
    public double averageBookPrize(List<Book> books) {
        return books.stream().mapToDouble(Book::getPrice).average().orElse(0);
    }

    @Override
    public int totalCost(List<Book> books) {
        return books.stream().mapToInt(Book::getPrice).sum();
    }

    @Override
    public IntSummaryStatistics booksStatistics(List<Book> books) {
        return books.stream()
                .mapToInt(Book::getPrice)
                .summaryStatistics();
    }

    @Override
    public String[] booksAuthors(List<Book> books) {
        return books.stream()
                .map(Book::getAuthor)
                .collect(Collectors.toList())
                .toArray(String[]::new);
    }


    @Override
    public String[] booksAuthors(List<Book> books, String nation) {
        return books.stream()
                .filter(b -> b.getNation().equals(nation))
                .map(Book::getAuthor)
                .collect(Collectors.toList())
                .toArray(String[]::new);
    }
}
