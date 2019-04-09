import java.util.Date;
import java.util.List;

public interface LibraryServiceInterface {
    public List<BookInterface> getAllBooks();

    public List<UserInterface> getAllUser();

    public List<AuthorInterface> getAllAuthor();

    public List<RentalInterface> getAllRental();


    public void deleteBook(Object bookInterface);

    public void deleteUser(Object user);

    public  void deleteRental(Object rental);

    public void deleteAuthor(Object author);

    public void updateBook(Object bookInterface);

    public void updateAuthr(Object author);

    public void updateRental(Object rental);

    public void updateUser(Object user);

    public void createAuthor(String firstName, String lastName);

    public void createBook(String title, Object author);

    public void createRental(Object book, Object user, Date rentalDate, Date returDate);

    public void createUser(String firstName, String lastName);
    public void createBook(BookInterface bookInterface);

    public void createBook(String firstName, String lastName, String title, String ISBN, Integer year, Double price);

    public  List<UserInterface> getFilteredUseByAuthorAndRentalDateBookTitle(String AuthorlastName, String bookTitle, Date startDate, Date returnDate);

    public List<AuthorInterface> getFilteredAuthorByUser(String firstName, String LastName);

    public List<AuthorInterface> getFilteredUserByBook(Object book);

    public AuthorInterface getMostPopulatAuthor();


}
