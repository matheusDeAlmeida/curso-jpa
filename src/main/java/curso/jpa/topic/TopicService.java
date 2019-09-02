package curso.jpa.topic;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//business services usually are singletons in spring
@Service
public class TopicService{
    
    @Autowired
    private TopicRepository topicRepository;

    //private ArrayList<Topic> topics = new ArrayList<Topic>(Arrays.asList());

    public List<Topic> getTopics() {
        //return this.topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        //return topicRepository.findOne(id);
        return topicRepository.findById(id).get();
    }

	public void addTopic(Topic topic) {
        topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
        /*for(int i=0; i<topics.size(); i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topic);
            }
        }*/
        topicRepository.save(topic); //save can do both: add and update
	}

	public void deleteTopic(String id) {
        //topics.removeIf(t->t.getId().equals(id));
        topicRepository.deleteById(id);
	}
}

