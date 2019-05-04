package repository;

import domain.Topic;
import domain.User;

import java.util.LinkedList;
import java.util.List;

public class UserRepository {

    public List<User> getAllUser() {

        TopicRepository topicRepository = new TopicRepository();
        List<User> seatList = new LinkedList<User>();
        User user = new User(0,"Marcin", "admin3", "admin3");
        user.setTopicList(topicRepository.getAllTopic());
        User user1 =new User(1,"Adrian", "admin", "admin");
        user1.setTopicList(topicRepository.getAllTopic());


        user.setTopicList(topicRepository.getAllTopic());
        seatList.add(user);
        seatList.add(user1);
        seatList.add(new User(2,"Jakub", "admin1", "admin1"));
        seatList.add(new User(3,"Kamil", "admin2", "admin2"));



        return seatList;
    }

}