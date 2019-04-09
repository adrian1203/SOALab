import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;



public class LibraryRepository {

    private EntityManagerFactory factory;
    EntityManager em;
    Logger logger = Logger.getLogger(LibraryRepository.class.getName());

    public LibraryRepository() {
        factory=Persistence.createEntityManagerFactory("JPA-test");
        em=factory.createEntityManager();
    }

    public List<BookInterface> getAllBook(){
        em.getTransaction().begin();
        Query q = em.createQuery("FROM Book ", Book.class);
        em.getTransaction().commit();
       return  q.getResultList();
    }
    public void createBook(Book book){
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();

    }

    public void updateBook(Object book){
        em.getTransaction().begin();
        em.merge((Book)book);
        em.getTransaction().commit();

    }

    public void deleteBook(Object book){
        em.getTransaction().begin();
        em.remove(em.contains((Book)book) ? book : em.merge((Book)book));
        em.getTransaction().commit();

    }

    public void createAuthor(Author author){
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();

    }

    public void updateAuthor(Object author){
        em.getTransaction().begin();
        em.merge((Author)author);
        em.getTransaction().commit();

    }

    public void deleteAuthor(Object author){
        em.getTransaction().begin();
        em.remove(em.contains((Author)author) ? author : em.merge((Author)author));
        em.getTransaction().commit();

    }

    public void createUser(User user){
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

    }

    public void updateUser(Object user){
        em.getTransaction().begin();
        em.merge((User)user);
        em.getTransaction().commit();

    }

    public void deleteUser(Object user){
        em.getTransaction().begin();
        em.remove(em.contains((User)user) ? user : em.merge((User)user));
        em.getTransaction().commit();

    }

    public void createRental(Rental rental){
        em.getTransaction().begin();
        em.persist(rental);
        em.getTransaction().commit();

    }

    public void updateRental(Object rental){
        em.getTransaction().begin();
        em.merge((Rental)rental);
        em.getTransaction().commit();

    }

    public void deleteRental(Object rental){
        em.getTransaction().begin();
        em.remove(em.contains((Rental)rental) ? rental : em.merge((Rental)rental));
        em.getTransaction().commit();

    }



    public List<UserInterface> getAllUser(){
        em.getTransaction().begin();
        Query q = em.createQuery("FROM User ", User.class);
        em.getTransaction().commit();
        return  q.getResultList();
    }

    public List<AuthorInterface> getAllAuthor(){
        em.getTransaction().begin();
        Query q = em.createQuery("FROM Author ", Author.class);
        em.getTransaction().commit();
        return  q.getResultList();
    }
    public List<RentalInterface> getAllRental(){
        em.getTransaction().begin();
        Query q = em.createQuery("FROM Rental ", Rental.class);
        em.getTransaction().commit();
        return  q.getResultList();
    }
}
