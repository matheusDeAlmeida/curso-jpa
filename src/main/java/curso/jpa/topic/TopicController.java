package curso.jpa.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //mvc detecta a annotation e converte em json
public class TopicController{
    @Autowired
    private TopicService courseService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){ //essa lista é convertida em json automaticamente
        return courseService.getTopics();
    }

    @RequestMapping("/topics/{id}") //variáveis vão dentro dos {}
    public Topic getTopic(@PathVariable String id){
        return courseService.getTopic(id);
    }

    //queremos esse método convertido numa função de adição de linhas para a classe TopicService
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic course){
        courseService.addTopic(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic course, @PathVariable String id){
        courseService.updateTopic(id, course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void delteTopic(@PathVariable String id){
        courseService.deleteTopic(id);
    }
}