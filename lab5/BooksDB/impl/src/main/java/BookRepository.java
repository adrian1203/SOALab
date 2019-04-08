import clojure.lang.Obj;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;



public class BookRepository {

    private EntityManagerFactory factory;
    EntityManager em;
    Logger logger = Logger.getLogger(BookRepository.class.getName());

    public BookRepository() {
        factory=Persistence.createEntityManagerFactory("JPA-test");
        em=factory.createEntityManager();
    }

    public List<Book> getAll(){
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
}
