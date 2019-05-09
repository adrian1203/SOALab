package service;

import clojure.lang.IFn;
import domain.Film;
import repository.FilmRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FilmService {


    FilmRepository filmRepository;

    public FilmService( ) {
        this.filmRepository = new FilmRepository();

    }
    public List<Film> getAllFilms(){
       return this.filmRepository.getAllFilms();
    }

    public Film getFilmById(Long id){
        return this.filmRepository.findFilmById(id);
    }
    public void deleteFilm(Long id){
        this.filmRepository.deleteUser(id);
    }
    public void updateFilm(Film film){
        this.filmRepository.updateFilm(film);
    }
    public void createFilm(Film film){
        this.filmRepository.createFilm(film);
    }
    public List<Film> getFilteredFilms( String title){
        List<Film> films = filmRepository.getAllFilms();
        List<Film> fiteredFilm=new LinkedList<Film>();
        //films.stream().filter(elem->{elem.getTitle().contains(title)}).collect(Collectors.toList());
        //TODO nie widzi API 8.0
        for(Film film : films){
            if(film.getTitle().contains(title)){fiteredFilm.add(film);}
        }
        return fiteredFilm;
    }
    public void updateURL(String url,Long id){
        Film film = filmRepository.findFilmById(id);
        film.setUri(url);
        filmRepository.updateFilm(film);
    }
}
