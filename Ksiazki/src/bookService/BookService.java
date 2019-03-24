package bookService;


import domain.Book;
import repository.BookRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name ="BookService")
@RequestScoped
public class BookService {



    private final BookRepository bookRepository;
    private Book criteriaBook;

    private List<Book> choosenBook;

    public List<Book> getChoosenBook() {
        return choosenBook;
    }

    public void setChoosenBook(List<Book> choosenBook) {
        this.choosenBook = choosenBook;
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
    }

    public List<Book> getAllBooks(){
        return this.bookRepository.getBookList();
    }

    public List<Book> getFilteredBooks(){

        return this.bookRepository.getBookList().stream().filter(book -> FiltrBook(book, criteriaBook)).collect(Collectors.toList());
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

//    public void prepareOrder(){
//        Double allCosts;
//        Count
//    }

    public Double allPrice(){
        Double price=0.0;
        for(Book book : choosenBook){
            price+=book.getPrice();
        }
        return price;
    }
    public Integer countBooks(){
        return choosenBook.size();
    }

}
