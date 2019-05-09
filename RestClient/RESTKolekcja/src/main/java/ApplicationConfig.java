import controllers.FilmController;
import controllers.UserController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class ApplicationConfig extends Application {

    private static final Set<Object>    singletons  = new HashSet<Object>();

    public ApplicationConfig() {
        singletons.add(new UserController());
        singletons.add(new FilmController());
       // singletons.add(com.github.phillipkruger.apiee.ApieeService.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>();
        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
