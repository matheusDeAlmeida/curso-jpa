package curso.jpa.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import curso.jpa.topic.Topic;

@RestController //mvc detecta a annotation e converte em json
public class CourseController{
    @Autowired
    private CourseService courseService;

    @RequestMapping("topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){ //essa lista é convertida em json automaticamente
        return courseService.getCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}") //variáveis vão dentro dos {}
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    //queremos esse método convertido numa função de adição de linhas para a classe TopicService
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}