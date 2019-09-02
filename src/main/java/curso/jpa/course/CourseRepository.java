package curso.jpa.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
    //getAllTopics()
    //getTopic(String id)
    //updateTopic(Topic t)
    //deleteTopic(String id)
    List<Course> findByTopicId(String name); //usando "findBy"+variável, o spring jpa implementa o método sozinho
    List<Course> findByDescription(String name);
}