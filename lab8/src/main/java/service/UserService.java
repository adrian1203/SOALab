package service;

import domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.logging.Logger;

@Stateful
public class UserService {
    private User logedUser;
    private Boolean islogged;
    private final static Logger LOGGER = Logger.getLogger(UserService.class.getName());


    @EJB
    ForumMenager forumMenager;

    public User getLogedUser() {
        return logedUser;
    }

    public void setLogedUser(User logedUser) {
        this.logedUser = logedUser;
    }

    public Boolean getIslogged() {
        return islogged;
    }

    public void setIslogged(Boolean islogged) {
        this.islogged = islogged;
    }

    public Boolean logIn(String login, String password){
        islogged=false;
        for(User user :forumMenager.getUsers() ){
            if(user.getLogin().equals(login) && user.getPassword().equals(password)){
                logedUser=user;
                islogged =true;
            }
        }
//        forumMenager.getUsers().forEach(user -> {
//            if(user.getLogin().equals(login) && user.getPassword().equals(password)){
//                logedUser=user;
//                islogged =true;
//            }
//        });
        LOGGER.info(forumMenager.getUsers().toString());
        LOGGER.info(login);
        LOGGER.info(password);

        for(User user : forumMenager.getUsers()){
            LOGGER.info(user.getLogin() + "vvvvv" + user.getPassword());
            if(user.getLogin().equals(login) && user.getPassword().equals(password)){
                logedUser=user;
                islogged =true;
                LOGGER.info(user.getLogin() + "vvvvv" + user.getPassword());
                return true;
            }
        }
        return false;
    }
    public void logOut(){
        islogged=false;
        logedUser=null;
    }
}
