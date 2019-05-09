package repository;

import domain.Film;
import domain.RentalUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FilmRepository {
    private EntityManagerFactory factory;
    EntityManager em;

    public FilmRepository() {
        factory= Persistence.createEntityManagerFactory("KolekcjaJPA");
        em=factory.createEntityManager();
    }

     public List<Film> getAllFilms(){
         em.getTransaction().begin();
         Query query = em.createQuery("FROM domain.Film ", Film.class);
         em.getTransaction().commit();
         return query.getResultList();
    }
    public Film findFilmById(Long id){
        em.getTransaction().begin();
        Film film = em.find(Film.class, id);
        em.getTransaction().commit();
        return film;
    }
    public void createFilm(Film film ){
        em.getTransaction().begin();
        em.persist(film);
        em.getTransaction().commit();
    }
    public void updateFilm(Film film){
        em.getTransaction().begin();
        em.merge(film);
        em.getTransaction().commit();
    }
    public void deleteUser(Long id){
        Film film = findFilmById(id);
        em.getTransaction().begin();
        em.remove(film);
        em.getTransaction().commit();

    }
}
