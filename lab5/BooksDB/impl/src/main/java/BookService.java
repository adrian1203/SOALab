import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;



@Stateful
@Remote(BookServiceInterface.class)
public class BookService implements BookServiceInterface {



    private BookRepository bookRepository;

    public BookService() {
        bookRepository=new BookRepository();
    }

    public List<BookInterface> getAll() {
        List<BookInterface> bookInterfaces=new ArrayList<BookInterface>();
        for(Book b : bookRepository.getAll()){
            bookInterfaces.add((BookInterface) b);
        }
        return bookInterfaces;

    }

    public void updateBook(Object bookInterface) {
        bookRepository.updateBook(bookInterface);

    }

    public void deleteBook(Object bookInterface) {
        bookRepository.deleteBook(bookInterface);

    }

    public void createBook(BookInterface bookInterface) {

    }

    public void createBook(String firstName, String lastName, String title, String ISBN, Integer year, Double price) {
//        Book book=new Book();
//        book.setFirstName(firstName);
//        book.setLastName(lastName);
//        book.setTitle(title);
//        book.setISBN(ISBN);
//        book.setYear(year);
//        book.setPrice(price);
//        bookRepository.createBook(book);
    }


}
