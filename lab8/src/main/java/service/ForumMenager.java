package service;

import domain.Topic;
import domain.User;
import repository.TopicRepository;
import repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.List;
import java.util.logging.Logger;

@Singleton
@Startup
public class ForumMenager {

    private final static Logger logger = Logger.getLogger(ForumMenager.class.getName());
    private List<User> users;
    private List<Topic> topics;


    @PostConstruct
    public void setupTheater(){
        logger.config("Inicjuje");
        UserRepository userRepository = new UserRepository();
        users = userRepository.getAllUser();
        TopicRepository topicRepository = new TopicRepository();
        topics = topicRepository.getAllTopic();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
