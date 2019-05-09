package repository;

import domain.Film;
import domain.RentalUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private EntityManagerFactory factory;
    EntityManager em;

    public UserRepository() {
        factory= Persistence.createEntityManagerFactory("KolekcjaJPA");
        em=factory.createEntityManager();
    }


    public List<RentalUser> getAllUsers(){
        em.getTransaction().begin();
        Query query = em.createQuery("FROM RentalUser ", RentalUser.class);
        em.getTransaction().commit();
        return query.getResultList();
    }
    public RentalUser findUserById(Long id){
        em.getTransaction().begin();
        RentalUser rentalUser = em.find(RentalUser.class, id);
        em.getTransaction().commit();
        return rentalUser;
    }
    public void createUser(RentalUser rentalUser){
        em.getTransaction().begin();
        em.persist(rentalUser);
        em.getTransaction().commit();
    }
    public void updateBook(RentalUser rentalUser){
        em.getTransaction().begin();
        em.merge(rentalUser);
        em.getTransaction().commit();
    }
    public void deleteUser(Long id){
        RentalUser rentalUser = findUserById(id);
        em.getTransaction().begin();
        em.remove(rentalUser);
        em.getTransaction().commit();

    }


}
