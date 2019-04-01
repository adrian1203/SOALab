import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote(InterfaceMain.class)
public class Implementacja implements InterfaceMain{


    public void foo() {

    }
}
