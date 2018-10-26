package enricmartos.springbootquickstart.controllers.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import enricmartos.springbootquickstart.models.Topic;
import enricmartos.springbootquickstart.services.TopicService;

@RestController
public class TopicRestController {
	
	//This annotation says that the attribute needs Dependency Injection
	@Autowired
	private TopicService topicService;
	
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	//Variables en les URL's->curly braces
	@RequestMapping("/topics/{id}")
	//Avisem que id és una variable del Path->Recomanable posar el mateix nom tant el path com a l'argument
	public Topic getTopic(@PathVariable Long id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value ="/topics")
	//@Request body indica que la instància de topic prové del cos de la petició 
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value ="/topics/{id}")
	//@Request body indica que la instància de topic prové del cos de la petició 
	public void updateTopic(@RequestBody Topic topic, @PathVariable Long id) {
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value= "/topics/{id}")
	//Avisem que id és una variable del Path->Recomanable posar el mateix nom tant el path com a l'argument
	public void deleteTopic(@PathVariable Long id) {
		topicService.deleteTopic(id);
	}

}
