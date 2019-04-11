import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private Object selectedAuthorToBook;
    private Object selectedUserToRental;
    private Object selectedBookToRental;

    private Date start;
    private Date end;


    private Date startDateFiltered;
    private Date endDateFiltered;
    private String authorFiltered;






    private String selectedAtohorIdToBook;

    public String getSelectedAtohorIdToBook() {
        return selectedAtohorIdToBook;
    }

    public void setSelectedAtohorIdToBook(String selectedAtohorIdToBook) {
        this.selectedAtohorIdToBook = selectedAtohorIdToBook;
    }

    public BookBeen() {
        selectedAuthorToBook = new Object();
    }

    @EJB(lookup = "java:global/impl-1.0-SNAPSHOT/LibraryService")
    private LibraryServiceInterface bookServiceInterface;


    public Object getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(BookInterface selectedBook) {
        this.selectedBook = selectedBook;
    }

    public LibraryServiceInterface getBookServiceInterface() {
        return bookServiceInterface;
    }

    public void setBookServiceInterface(LibraryServiceInterface bookServiceInterface) {
        this.bookServiceInterface = bookServiceInterface;
    }


    public String createBook(String firstName) {

        this.bookServiceInterface.createBook(firstName,selectedAuthorToBook);

        return "/index.xhtml?faces-redirect=true";
    }

    public String createUser(String firstName, String lastname) {

        this.bookServiceInterface.createUser(firstName, lastname);

        return "/index.xhtml?faces-redirect=true";
    }

    public String createAuthor(String firstName, String lastname) {

        this.bookServiceInterface.createAuthor(firstName, lastname);

        return "/index.xhtml?faces-redirect=true";
    }

    public String createRental(String startDate, String returnDate) throws ParseException {

//        DateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss");
//
//        Date start= format.parse(startDate);
//
//        Date endDate= format.parse(returnDate);
        this.bookServiceInterface.createRental(selectedBookToRental, selectedUserToRental, this.start,this.end);

        return "/index.xhtml?faces-redirect=true";
    }



    public String modify(Object book){
        selectedBook=new Object() {};
        selectedBook= book;
        return "/book-modify.xhtml?faces-redirect=true";
    }

    public String update(){

        this.bookServiceInterface.updateBook( selectedBook);
        return "/index.xhtml";

    }


//    public List<Object>getFilterdUser(){
//
//       return  (O)this.bookServiceInterface.getFilteredUseByAuthorAndRentalDateBookTitle(this.authorFiltered, null, startDateFiltered, endDateFiltered)
//    }

    public void setSelectedBook(Object selectedBook) {
        this.selectedBook = selectedBook;
    }

    public Object getSelectedAuthorToBook() {
        return selectedAuthorToBook;
    }

    public void setSelectedAuthorToBook(Object selectedAuthorToBook) {
        this.selectedAuthorToBook = selectedAuthorToBook;
    }

    public Object getSelectedUserToRental() {
        return selectedUserToRental;
    }

    public void setSelectedUserToRental(Object selectedUserToRental) {
        this.selectedUserToRental = selectedUserToRental;
    }

    public Object getSelectedBookToRental() {
        return selectedBookToRental;
    }

    public void setSelectedBookToRental(Object selectedBookToRental) {
        this.selectedBookToRental = selectedBookToRental;
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

    public Date getStartDateFiltered() {
        return startDateFiltered;
    }

    public void setStartDateFiltered(Date startDateFiltered) {
        this.startDateFiltered = startDateFiltered;
    }

    public Date getEndDateFiltered() {
        return endDateFiltered;
    }

    public void setEndDateFiltered(Date endDateFiltered) {
        this.endDateFiltered = endDateFiltered;
    }

    public String getAuthorFiltered() {
        return authorFiltered;
    }

    public void setAuthorFiltered(String authorFiltered) {
        this.authorFiltered = authorFiltered;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
}
