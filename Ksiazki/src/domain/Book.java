package domain;

import domain.enums.BookType;
import domain.enums.Currency;

public class Book {
    private Long id;
    private String title;
    private String author;
    private BookType bookType;
    private Double price;
    private Currency currency;
    private Integer numberOfPage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Integer getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(Integer numberOfPage) {
        this.numberOfPage = numberOfPage;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Book(Long id, String title, String author, BookType bookType, Double price, Currency currency, Integer numberOfPage) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.bookType = bookType;
        this.price = price;
        this.currency = currency;
        this.numberOfPage = numberOfPage;
    }

    public Book() {
    }
}
