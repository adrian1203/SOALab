package repository;

import domain.Book;
import domain.enums.BookType;
import domain.enums.Currency;

import java.util.LinkedList;
import java.util.List;



public class BookRepository {

    List<Book> bookList = new LinkedList<Book>();

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public BookRepository() {
        bookList.add(new Book(1L,"Zemsta", "Fredro", BookType.KRYMINAŁ, 23.02, Currency.PLN, 369));
        bookList.add(new Book(2L,"Mitologia", "Anonim", BookType.PRZYGODOWA, 23.2, Currency.DOLAR, 69));
        bookList.add(new Book(3L,"Pan Tadesuzz", "Mickiewicz", BookType.BIOGRAFIA, 3.02, Currency.DOLAR, 359));
        bookList.add(new Book(4L,"Kordian", "Słowacki", BookType.WOJENNA, 3.25, Currency.EURO, 8369));
        bookList.add(new Book(4L,"Angular 6", " Freeman ", BookType.PUBLICYSTYCZNA, 3.25, Currency.PLN, 309));


    }

}
