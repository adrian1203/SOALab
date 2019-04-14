import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;


@Stateful
@Remote(LibraryServiceInterface.class)
public class LibraryService implements LibraryServiceInterface {

    Logger logger = Logger.getLogger(LibraryService.class.getName());

    private LibraryRepository libraryRepository;

    public LibraryService(){
        this.libraryRepository = new LibraryRepository();
    }


    public List<BookInterface> getAllBooks() {
        return libraryRepository.getAllBook();
    }

    public List<UserInterface> getAllUser() {
        return this.libraryRepository.getAllUser();
    }

    public List<AuthorInterface> getAllAuthor() {
        return this.libraryRepository.getAllAuthor();
    }

    public List<RentalInterface> getAllRental() {
        return this.libraryRepository.getAllRental();
    }

    public void deleteBook(Object bookInterface) {
        this.libraryRepository.deleteBook(bookInterface);
    }

    public void deleteUser(Object user) {
        this.libraryRepository.deleteUser(user);

    }

    public void deleteRental(Object rental) {
        this.libraryRepository.deleteRental(rental);

    }

    public void deleteAuthor(Object author) {
        this.libraryRepository.deleteAuthor(author);

    }

    public void updateBook(Object bookInterface) {
        this.libraryRepository.updateBook(bookInterface);

    }

    public void updateAuthr(Object author) {
        this.libraryRepository.updateAuthor(author);

    }

    public void updateRental(Object rental) {
        this.libraryRepository.updateRental(rental);

    }

    public void updateUser(Object user) {
        this.libraryRepository.updateUser(user);

    }

    public void createAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        this.libraryRepository.createAuthor(author);
    }

    public void createBook(String title, Object author) {


        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(this.libraryRepository.findAuthorById(Long.parseLong((String)author)));
        this.libraryRepository.createBook(book);

    }

    public void createRental(Object book, Object user, Date rentalDate, Date returDate) {
        Rental rental = new Rental();
        rental.setBook(this.libraryRepository.findBookById(Long.parseLong((String)book)));
        rental.setUser(this.libraryRepository.findUserById(Long.parseLong((String)user)));
        rental.setRentaDate(rentalDate);
        rental.setReturnDate(returDate);
        this.libraryRepository.createRental(rental);
    }

    public void createUser(String firstName, String lastName) {
        User user= new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        this.libraryRepository.createUser(user);
    }

    public void createBook(BookInterface bookInterface) {

    }

    public void createBook(String firstName, String lastName, String title, String ISBN, Integer year, Double price) {

    }

    public List<Object> getFilteredUseByAuthorAndRentalDateBookTitle(String AuthorlastName, String bookTitle, Date startDate, Date returnDate) {
        return  libraryRepository.getFilteredUseByAuthorAndRentalDateBookTitle(AuthorlastName, bookTitle, startDate, returnDate);
    }

    public List<Object> getFilteredAuthorByUser(String firstName, String LastName) {


        return libraryRepository.getFilteredAuthorByUser(firstName, LastName);
    }

    public List<Object> getFilteredUserByBook(Object book) {


        return libraryRepository.getFilteredUserByBook(book);
    }

    public AuthorInterface getMostPopulatAuthor() {
        return null;
    }
}
