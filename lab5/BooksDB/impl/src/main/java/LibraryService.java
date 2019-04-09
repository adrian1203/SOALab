import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;


@Stateful
@Remote(LibraryServiceInterface.class)
public class LibraryService implements LibraryServiceInterface {


    @Inject
    private LibraryRepository libraryRepository;


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
        book.setAuthor((Author) author);
        this.libraryRepository.createBook(book);

    }

    public void createRental(Object book, Object user, Date rentalDate, Date returDate) {
        Rental rental = new Rental();
        rental.setBook((Book) book);
        rental.setUser((User) user);
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

    public List<UserInterface> getFilteredUseByAuthorAndRentalDateBookTitle(String AuthorlastName, String bookTitle, Date startDate, Date returnDate) {
        return null;
    }

    public List<AuthorInterface> getFilteredAuthorByUser(String firstName, String LastName) {
        return null;
    }

    public List<AuthorInterface> getFilteredUserByBook(Object book) {
        return null;
    }

    public AuthorInterface getMostPopulatAuthor() {
        return null;
    }
}
