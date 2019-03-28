package bookService;


import domain.Book;
import domain.enums.Currency;
import repository.BookRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlSelectManyCheckbox;
import javax.faces.component.html.HtmlSelectManyListbox;
import javax.faces.component.html.HtmlSelectManyMenu;
import javax.faces.component.html.HtmlSelectOneMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@ManagedBean(name ="BookService")
@SessionScoped
public class BookService {
    private final Double EuroToPln = 4.07;
    private final Double DolarToPln = 3.56;
    private final BookRepository bookRepository;
    private Book criteriaBook;
    private HtmlSelectManyCheckbox htmlSelectManyCheckbox;
    private Double minPrice;
    private Double maxPrice;
    private String selectCurrency;
    private HtmlSelectOneMenu htmlSelectOneMenu;
    private HtmlSelectOneMenu htmlSelectOneMenuFilterCurrency;
    private String selectFilterCurrency;
    private String[] selectedType;

    private final static Logger LOGGER = Logger.getLogger(BookService.class.getName());


    private HtmlSelectManyListbox htmlSelectManyListbox;

    public HtmlSelectManyListbox getHtmlSelectManyListbox() {
        return htmlSelectManyListbox;
    }

    public void setHtmlSelectManyListbox(HtmlSelectManyListbox htmlSelectManyListbox) {
        this.htmlSelectManyListbox = htmlSelectManyListbox;
    }

    public String[] getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(String[] selectedType) {
        this.selectedType = selectedType;
    }



    public HtmlSelectOneMenu getHtmlSelectOneMenuFilterCurrency() {
        return htmlSelectOneMenuFilterCurrency;
    }

    public void setHtmlSelectOneMenuFilterCurrency(HtmlSelectOneMenu htmlSelectOneMenuFilterCurrency) {
        this.htmlSelectOneMenuFilterCurrency = htmlSelectOneMenuFilterCurrency;
    }

    public String getSelectFilterCurrency() {
        return selectFilterCurrency;
    }

    public void setSelectFilterCurrency(String selectFilterCurrency) {
        this.selectFilterCurrency = selectFilterCurrency;
    }

    public HtmlSelectOneMenu getHtmlSelectOneMenu() {
        return htmlSelectOneMenu;
    }

    public void setHtmlSelectOneMenu(HtmlSelectOneMenu htmlSelectOneMenu) {
        this.htmlSelectOneMenu = htmlSelectOneMenu;
    }

    public String getSelectCurrency() {
        return selectCurrency;
    }

    public void setSelectCurrency(String selectCurrency) {
        this.selectCurrency = selectCurrency;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    private List<Book> bookList=new ArrayList<Book>();

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    private List<Book> choosenBook=new ArrayList<Book>();

    private Boolean createAnswer;

    public Boolean getCreateAnswer() {
        return createAnswer;
    }

    public void setCreateAnswer(Boolean createAnswer) {
        this.createAnswer = createAnswer;
    }

    public List<Book> getChoosenBook() {
        return choosenBook;
    }

    public void setChoosenBook(List<Book> choosenBook) {
        this.choosenBook = choosenBook;
    }

    public HtmlSelectManyCheckbox getHtmlSelectManyCheckbox() {
        return htmlSelectManyCheckbox;
    }

    public void setHtmlSelectManyCheckbox(HtmlSelectManyCheckbox htmlSelectManyCheckbox) {
        this.htmlSelectManyCheckbox = htmlSelectManyCheckbox;
    }

    public Book getCriteriaBook() {
        return criteriaBook;
    }

    public void setCriteriaBook(Book criteriaBook) {
        this.criteriaBook = criteriaBook;
    }

    public BookService() {
        this.bookRepository = new BookRepository();
        this.criteriaBook = new Book();
        bookList = this.bookRepository.getBookList();
    }

    public List<Book> getAllBooks(){
        return this.bookRepository.getBookList();
    }

    public void getFilteredBooks(){
        this.displayPrice();
        bookList=new ArrayList<Book>();
        List<Book> tmp = this.bookRepository.getBookList();
        for(Book book : tmp){
            if(FiltrBook(book)){
                bookList.add(book);
            }
        }
    }

    public Boolean FiltrBook(Book book){
        if(this.minPrice!=null){
            if(book.getPrice()<this.minPrice){return false;}

        }
        if(this.maxPrice!=null){
            if(book.getPrice()>this.maxPrice){return false;}
        }
        if(this.selectFilterCurrency!=null){
            if(!this.selectFilterCurrency.equals(book.getCurrency().toString())){return false;}

        }
        if(selectedType!=null){
            for(String str :selectedType){
                if(str.equals(book.getBookType().toString())){
                    return false;
                }
            }
        }

        return true;
    }
    public void clearFiltr(){
        this.maxPrice=null;
        this.minPrice=null;
        this.bookList=this.bookRepository.getBookList();
        this.selectedType=null;
        this.selectFilterCurrency=null;
    }

    public void displayPrice(){
        this.bookList=new ArrayList<Book>();
        this.bookList=this.bookRepository.getBookList();
        if("PLN".equals(this.htmlSelectOneMenu.getValue().toString())){
            this.bookList=this.bookRepository.getBookList();
            for(Book book:this.bookList){
                if(book.getCurrency()== Currency.EURO){book.setPrice(book.getPrice()*this.EuroToPln); }
                if(book.getCurrency()== Currency.DOLAR){book.setPrice(book.getPrice()*this.DolarToPln);}
                book.setCurrency(Currency.PLN);
            }
        }
        if("orginal".equals(this.htmlSelectOneMenu.getValue().toString())){
            this.bookList=this.bookRepository.getBookList();
        }
    }
    public Boolean FiltrBook(Book book, Book criteria){
        if(criteria.getAuthor()!=null){
            if(!book.getAuthor().contains(criteria.getAuthor())){
                return false;
            }
        }
        if(criteria.getAuthor()!=null){
            if(!book.getAuthor().contains(criteria.getAuthor())){
                return false;
            }
        }
        if(criteria.getBookType()!=null){
            if(book.getBookType()!=criteria.getBookType()){
                return false;
            }
        }
        if(criteria.getPrice()!=null){
            if(book.getPrice()!=criteria.getPrice()){
                return false;
            }
        }
        if(criteria.getCurrency()!=null){
            if(book.getCurrency()!=criteria.getCurrency()){
                return false;
            }
        }
        if(criteria.getNumberOfPage()!=null){
            if(book.getNumberOfPage()!=criteria.getNumberOfPage()){
                return false;
            }
        }
        return true;
    }

    public void prepareOrder(){

    }

    public Double allPrice(){

        Double price=0.0;
        for(Book book : choosenBook){
            if(book.getCurrency()== Currency.PLN){price+=book.getPrice(); }
            if(book.getCurrency()== Currency.EURO){price+=book.getPrice()*this.EuroToPln; }
            if(book.getCurrency()== Currency.DOLAR){price+=book.getPrice()*this.DolarToPln; }
        }
        return price;
    }
    public Integer countBooks(){
        return choosenBook.size();
    }

    public void addToBucket (Book book){
        choosenBook.add(book);
    }
    public void removeFromBucket(Book book){
        choosenBook.remove(book);
    }

    public void createAnswer(){
        this.createAnswer = true;
    }

}
