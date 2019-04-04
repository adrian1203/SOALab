import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@SessionScoped
@ManagedBean
@Named("BookBeen")
public class BookBeen implements Serializable {

    private String firstname;
    private String lastname;
    private String title;
    private String ISBN;
    private Integer year;
    private Double price;
    private Object selectedBook;


    @EJB(lookup = "java:global/impl-1.0-SNAPSHOT/BookService")
    private BookServiceInterface bookServiceInterface;


    public Object getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(BookInterface selectedBook) {
        this.selectedBook = selectedBook;
    }

    public void foo() {


        bookServiceInterface.getAll();
    }

    public BookServiceInterface getBookServiceInterface() {
        return bookServiceInterface;
    }

    public void setBookServiceInterface(BookServiceInterface bookServiceInterface) {
        this.bookServiceInterface = bookServiceInterface;
    }


    public String createBook(String firstName, String lastName, String title, String ISBN, String year, String price) {

        this.bookServiceInterface.createBook(firstName, lastName, title, ISBN, Integer.parseInt(year), Double.parseDouble(price));

        return "/index.xhtml?faces-redirect=true";
    }

    public String modify(Object book){
        selectedBook=new Object() {};
        selectedBook= book;
        return "/book-modify.xhtml?faces-redirect=true";
    }

    public String update(){

        this.bookServiceInterface.updateBook( selectedBook);
        return "/index.xhtml?faces-redirect=true";

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
