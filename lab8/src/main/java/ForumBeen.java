

import service.ForumMenager;
import service.TopicService;
import service.UserService;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.faces.bean.ManagedBean;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;


@MessageDriven(name = "MyMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
@ManagedBean(name = "ForumBeen")
public class ForumBeen  implements MessageListener {
    private final static Logger LOGGER = Logger.getLogger(ForumBeen.class.getName());
    String selectedTopic;
    String selectedUser;

    public ForumBeen() {
        this.messages.add("Jeabc to");
    }

    List<String> messages=new LinkedList<String>();

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getSelectedTopic() {
        return selectedTopic;
    }

    public void setSelectedTopic(String selectedTopic) {
        this.selectedTopic = selectedTopic;
    }

    public String getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(String selectedUser) {
        this.selectedUser = selectedUser;
    }

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

    @EJB
    TopicService topicService;

    @EJB
    ForumMenager forumMenager;

    public TopicService getTopicService() {
        return topicService;
    }

    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

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
            return "/forum.xhtml";
        }else return "/index.xhtml";
    }

    public ForumMenager getForumMenager() {
        return forumMenager;
    }

    public void setForumMenager(ForumMenager forumMenager) {
        this.forumMenager = forumMenager;
    }

    public void sendMessageToTopic(String message){
        LOGGER.info(message);
        LOGGER.info( selectedTopic);
        myProducer.enqueue(message);

    }

    public void sendMessageToUser(String message){
        LOGGER.info(message);
        LOGGER.info( selectedUser);
        myProducer.enqueue(message);
        messages.add(message);
    }
    public void onMessage(final Message msg) {
        if (msg instanceof TextMessage) {
            try {
                final String text = ((TextMessage) msg).getText();
                //LOGGER.info(() -> "Received: " + text);
                LOGGER.info(text);
                messages.add(text);
                LOGGER.info("tutjajjjjjjjjjjjj");
                LOGGER.info( String.valueOf(messages.size()));
            } catch (final JMSException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
