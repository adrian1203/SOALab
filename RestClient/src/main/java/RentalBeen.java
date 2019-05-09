

;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Film;
import domain.RentalUser;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.faces.bean.ManagedBean;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;


@ManagedBean(name = "RentalBeen")
public class RentalBeen {

    Logger logger = Logger.getLogger(RentalBeen.class.getName());


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
            films = mapper.readValue(value, new TypeReference<List<RentalUser>>(){});
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

}
