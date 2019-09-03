package curso.jpa.course;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//business services usually are singletons in spring
@Service
public class CourseService{
    
    @Autowired
    private CourseRepository courseRepository;

    //private ArrayList<Topic> courses = new ArrayList<Topic>(Arrays.asList());

    public List<Course> getCourses(String topicId) {
        //return this.courses;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        //courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id){
        //return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        //return courseRepository.findOne(id);
        return courseRepository.findById(id).get();
    }

	public void addCourse(Course course) {
        courseRepository.save(course);
	}

	public void updateCourse(Course course) {
        /*for(int i=0; i<courses.size(); i++){
            Topic t = courses.get(i);
            if(t.getId().equals(id)){
                courses.set(i, course);
            }
        }*/
        courseRepository.save(course); //save can do both: add and update
	}

	public void deleteCourse(String id) {
        //courses.removeIf(t->t.getId().equals(id));
        courseRepository.deleteById(id);
	}
}

