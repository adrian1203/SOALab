package controllers;


import domain.Film;
import domain.RentalUser;
import service.FilmService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("/films")
public class FilmController {

    Logger logger = Logger.getLogger(UserController.class.getName());
    FilmService filmService;

    public FilmController( ) {
        this.filmService = new FilmService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> getAllFilms() {
        return this.filmService.getAllFilms();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Film getUserById(@PathParam("id") Long id) {
        return this.filmService.getFilmById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postUser(Film film){
        this.filmService.createFilm(film);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putUser(Film film,@PathParam("id") Long id){
        this.filmService.updateFilm(film);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void deleteUser(@PathParam("id") Long id ){
        this.filmService.deleteFilm(id);
    }

    @GET
    @Path("filtered")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> getFilteredFilms(@QueryParam("title") String title){
        return this.filmService.getFilteredFilms(title);
    }

    @PATCH
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateURL(String URl, @PathParam("id") Long id){
        logger.info(URl);
        this.filmService.updateURL(URl, id);
    }


}
