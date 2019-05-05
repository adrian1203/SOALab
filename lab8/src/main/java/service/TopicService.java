package service;

import domain.Topic;
import repository.TopicRepository;

import javax.ejb.Stateful;
import java.util.List;

@Stateful

public class TopicService {

    public List<Topic> getAllTopic(){
        TopicRepository topicRepository = new TopicRepository();
        return topicRepository.getAllTopic();
    }

}
