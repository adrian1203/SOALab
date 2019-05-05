package repository;

import domain.Topic;

import java.util.LinkedList;
import java.util.List;

public class TopicRepository {

    public List<Topic> getAllTopic() {

        List<Topic> topicList = new LinkedList<Topic>();
        topicList.add(new Topic("temat1", "opis1"));
        topicList.add(new Topic("temat2", "opis2"));
        topicList.add(new Topic("temat3", "opis3"));


        return topicList;
    }
}
