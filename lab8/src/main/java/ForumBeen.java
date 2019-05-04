

import service.UserService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.logging.Logger;

@ManagedBean(name = "ForumBeen")
public class ForumBeen {
    private final static Logger LOGGER = Logger.getLogger(ForumBeen.class.getName());


    // https://nozaki.me/roller/kyle/entry/in-container-jms-consumer-producer
    @EJB
    MyProducer myProducer;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @EJB
    private UserService userService;


    //private MyProducer myProducer =  new MyProducer();
     public void send() throws ServletException, IOException {
        final String text = "Hello, JMS!";
        myProducer.enqueue(text);

       // resp.getWriter().write("Published! check output of the consumer: " + text + "\n");
    }

    public String logIn(String loging, String password){
        LOGGER.info("działąmdmdmddd");
        System.out.println("działm");
        LOGGER.info(userService.logIn(loging,password).toString());

        if(userService.logIn(loging,password)){
            return "/rezerwacja.xhtml";
        }else return "/index.xhtml";
    }
}
