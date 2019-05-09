

import javax.faces.bean.ManagedBean;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;


@ManagedBean(name = "RentalBeen")
public class RentalBeen {

    Logger logger = Logger.getLogger(RentalBeen.class.getName());


    public RentalBeen() {
//        ResteasyClient client = new ResteasyClientBuilder().build();
//        ResteasyWebTarget target = client.target("http://localhost:8080/RESTKolekcja-1.0-SNAPSHOT/rest/films");
//        Response response = target.request().get();
//        String value = response.readEntity(String.class);
//        logger.info(value);
    }



}
