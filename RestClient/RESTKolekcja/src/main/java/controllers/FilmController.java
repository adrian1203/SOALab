package controllers;


import domain.Film;

import service.FilmService;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
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
//    @GET
//    @Path("swagger")
//    @ApiOperation(value = "Retrieve some example content", notes = "Return some json to the client")
//    public Response getExample(){
//        JsonObject jsonObject = Json.createObjectBuilder().add("name", "apiee example").add("url", "https://github.com/phillip-kruger/apiee-example").build();
//        //log.log(Level.INFO, "GET: {0}", jsonObject);
//        return Response.ok(jsonObject).build();
//    }
//    @GET
//    @Produces(MediaType.APPLICATION_JSON_TYPE.)
//    public List<domain.Film> getAllFilmsContenetNegotiation() {
//        return this.filmService.getAllFilms();
//    }





}
