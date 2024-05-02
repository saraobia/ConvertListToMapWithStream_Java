package org.example;

import java.util.Objects;

public class Book {
    private String isbn;
    private String description;
    private String author;
    private String nation;
    private int price;

    public Book() {
    }

    public Book(String isbn, String description, String author, String nation, int price) {
        this.isbn = isbn;
        this.description = description;
        this.author = author;
        this.nation = nation;
        this.price = price;
    }

    public Book(String description, String author, String nation, int price) {
        this.description = description;
        this.author = author;
        this.nation = nation;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price && Objects.equals(isbn, book.isbn) && Objects.equals(description, book.description) && Objects.equals(author, book.author) && Objects.equals(nation, book.nation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, description, author, nation, price);
    }
    //?
    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", nation='" + nation + '\'' +
                ", price=" + price +
                '}';
    }

    //comparator?
}
