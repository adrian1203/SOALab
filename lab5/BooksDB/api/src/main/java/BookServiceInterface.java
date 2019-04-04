import java.util.List;

public interface BookServiceInterface {
    public List<BookInterface> getAll();

    public void updateBook(Object bookInterface);

    public void deleteBook(Object bookInterface);

    public void createBook(BookInterface bookInterface);

    public void createBook(String firstName, String lastName, String title, String ISBN, Integer year, Double price);


}
