

;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Film;
import domain.RentalUser;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;


@SessionScoped
@ManagedBean(name = "RentalBeen")
public class RentalBeen {

    Logger logger = Logger.getLogger(RentalBeen.class.getName());
    private List<Film> choosedFilm = new ArrayList<Film>();
    private Film selectedFilm;
    private RentalUser selectedUser;

    public RentalUser getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(RentalUser selectedUser) {
        this.selectedUser = selectedUser;
    }

    public Film getSelectedFilm() {
        return selectedFilm;
    }

    public void setSelectedFilm(Film selectedFilm) {
        this.selectedFilm = selectedFilm;
    }

    public List<Film> getChoosedFilm() {
        return choosedFilm;
    }

    public void setChoosedFilm(List<Film> choosedFilm) {
        this.choosedFilm = choosedFilm;
    }

    public RentalBeen() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/RESTKolekcja_war/rest/users");
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        logger.info(value);
    }
//    public String test (){
//        ResteasyClient client = new ResteasyClientBuilder().build();
//        ResteasyWebTarget target = client.target("http://localhost:8080/RESTKolekcja_war/rest/users/1623");
//        Response response = target.request().get();
//        String value = response.readEntity(String.class);
//        logger.info(value);
//        ObjectMapper mapper=new ObjectMapper();
//        try {
//
//
//            domain.RentalUser staff2 = mapper.readValue(value, domain.RentalUser.class);
//
//            // compact print
//            System.out.println(staff2);
//
//            // pretty print
//            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff2);
//
//            System.out.println(prettyStaff1);
//            logger.info(staff2.toString());
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "/index.xhtml?faces-redirect=true";
//    }

    public List<RentalUser> getAllUser(){
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/RESTKolekcja_war/rest/users");
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        logger.info(value);
        ObjectMapper mapper=new ObjectMapper();
        List<RentalUser> myObjects=new LinkedList<RentalUser>();
        try {
            myObjects = mapper.readValue(value, new TypeReference<List<RentalUser>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myObjects;
    }
    public List<Film> getAllFilms(){
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/RESTKolekcja_war/rest/films");
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        ObjectMapper mapper=new ObjectMapper();
        List<Film> films=new LinkedList<Film>();
        try {
            films = mapper.readValue(value, new TypeReference<List<Film>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return films;
    }

    public void deleteUser(Long id){
        ResteasyClient client = new ResteasyClientBuilder().build();
        String url ="http://localhost:8080/RESTKolekcja_war/rest/users/"+id;
        ResteasyWebTarget target = client.target(url);
        Response response = target.request().delete();
    }
    public void deleteFilm(Long id){
        ResteasyClient client = new ResteasyClientBuilder().build();
        String url ="http://localhost:8080/RESTKolekcja_war/rest/films/"+id;
        ResteasyWebTarget target = client.target(url);
        Response response = target.request().delete();
    }

    public void createFilm(Film film){
        ResteasyClient client = new ResteasyClientBuilder().build();
        String url ="http://localhost:8080/RESTKolekcja_war/rest/films";
      ResteasyWebTarget target = client.target(url);
//        Response response =target.request().header("Content-Type","application/json").post(film);
        Response response = target.request().post(Entity.entity(film,MediaType.APPLICATION_JSON));
       // Response response = target.request().delete();
        logger.info(response.getHeaders().toString());
    }
    public String createUserREST(RentalUser user){
        ResteasyClient client = new ResteasyClientBuilder().build();
        String url ="http://localhost:8080/RESTKolekcja_war/rest/users";
        ResteasyWebTarget target = client.target(url);
        logger.info("Tworze usera");
        logger.info(String.valueOf(user.getFilms().size()));
//        Response response =target.request().header("Content-Type","application/json").post(film);
        Response response = target.request().post(Entity.entity(user,MediaType.APPLICATION_JSON));
        // Response response = target.request().delete();
        logger.info(response.getHeaders().toString());
        return "/index.xhtml?faces-redirect=true";

    }
    public String createFilm(String title, String uri){
        Film film = new Film(title,uri);
        createFilm(film);
        return "/index.xhtml?faces-redirect=true";
    }
    public String createUser(String firstname, String lastName){

        RentalUser rentalUser = new RentalUser();
        rentalUser.setFirstName(firstname);
        rentalUser.setLastName(lastName);
        logger.info(firstname);
        logger.info(lastName);
        logger.info(String.valueOf(choosedFilm.size()));
        rentalUser.setFilms(choosedFilm);
        choosedFilm=new LinkedList<Film>();
        return createUserREST(rentalUser);

       // return "/index.xhtml?faces-redirect=true";

    }
    public String modifyFilm(Film film){
        selectedFilm=film;
        return "/film-modify.xhtml?faces-redirect=true";
    }
    public String updateFilm(){
        ResteasyClient client = new ResteasyClientBuilder().build();
        String url ="http://localhost:8080/RESTKolekcja_war/rest/films/"+selectedFilm.getId();
        ResteasyWebTarget target = client.target(url);
//        Response response =target.request().header("Content-Type","application/json").post(film);
        Response response = target.request().put(Entity.entity(selectedFilm,MediaType.APPLICATION_JSON));
        // Response response = target.request().delete();
        logger.info(response.getHeaders().toString());

        return "/index.xhtml?faces-redirect=true";

    }

    public String modifyUser(RentalUser user){
        selectedUser=user;
        return "/user-modify.xhtml?faces-redirect=true";
    }
    public String updateUser(){
        ResteasyClient client = new ResteasyClientBuilder().build();
        String url ="http://localhost:8080/RESTKolekcja_war/rest/users/"+selectedUser.getId();
        ResteasyWebTarget target = client.target(url);
        Response response = target.request().put(Entity.entity(selectedUser,MediaType.APPLICATION_JSON));
        logger.info(response.getHeaders().toString());

        return "/index.xhtml?faces-redirect=true";

    }
    public void displayChoosedFilm(){
        logger.info(String.valueOf(choosedFilm.size()));
    }



}
