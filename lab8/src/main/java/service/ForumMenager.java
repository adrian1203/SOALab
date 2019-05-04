package service;

import domain.User;
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


    @PostConstruct
    public void setupTheater(){
        logger.config("Inicjuje");
        UserRepository userRepository = new UserRepository();
        users = userRepository.getAllUser();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
