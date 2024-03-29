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
    private TopicRepository courseRepository;

    //private ArrayList<Topic> courses = new ArrayList<Topic>(Arrays.asList());

    public List<Topic> getTopics() {
        //return this.courses;
        List<Topic> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Topic getTopic(String id){
        //return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        //return courseRepository.findOne(id);
        return courseRepository.findById(id).get();
    }

	public void addTopic(Topic course) {
        courseRepository.save(course);
	}

	public void updateTopic(String id, Topic course) {
        /*for(int i=0; i<courses.size(); i++){
            Topic t = courses.get(i);
            if(t.getId().equals(id)){
                courses.set(i, course);
            }
        }*/
        courseRepository.save(course); //save can do both: add and update
	}

	public void deleteTopic(String id) {
        //courses.removeIf(t->t.getId().equals(id));
        courseRepository.deleteById(id);
	}
}

