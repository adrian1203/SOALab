import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
@ManagedBean
public class Been implements Serializable {

    @EJB(lookup = "java:global/impl-1.0-SNAPSHOT/Implementacja")
    private InterfaceMain implementacja;


    public void foo(){
        implementacja.foo();
    }






}
