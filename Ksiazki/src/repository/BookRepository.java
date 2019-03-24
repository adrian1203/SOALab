package repository;

import domain.Book;
import domain.enums.BookType;
import domain.enums.Currency;

import java.util.LinkedList;
import java.util.List;



public class BookRepository {

    List<Book> bookList = new LinkedList<>();

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public BookRepository() {
        bookList.add(new Book(1L,"Tytuł", "Autor", BookType.KRYMINAŁ, 23.02, Currency.PLN, 369));
        bookList.add(new Book(2L,"Tydddtuł", "Audddtor", BookType.KRYMINAŁ, 23.2, Currency.DOLAR, 369));
        bookList.add(new Book(3L,"tuł", "Auor", BookType.KRYMINAŁ, 3.02, Currency.DOLAR, 369));
        bookList.add(new Book(4L,"Tytufdfł", "Adsfdutor", BookType.KRYMINAŁ, 3.25, Currency.EURO, 369));

    }

}
