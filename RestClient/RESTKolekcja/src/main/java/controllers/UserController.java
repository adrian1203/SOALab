package controllers;

import domain.Film;
import domain.RentalUser;
import service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

@Path("/users")
public class UserController {

    Logger logger = Logger.getLogger(UserController.class.getName());
    private UserService userService;

    public UserController( ) {
        this.userService = new UserService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RentalUser> getAllUsers() {
        return this.userService.getAllUser();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public RentalUser getUserById(@PathParam("id") Long id) {
        return this.userService.getUserById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postUser(RentalUser rentalUser){
        this.userService.createUser(rentalUser);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putUser(RentalUser rentalUser,@PathParam("id") Long id){
        this.userService.updateUser(rentalUser);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void deleteUser(@PathParam("id") Long id ){
        this.userService.deleteUser(id);
    }


    @GET
    @Path("{id}/films")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> getFavoriteFilm(@PathParam("id") Long id) {
        return this.userService.getFavouriteFilm(id);
    }




}