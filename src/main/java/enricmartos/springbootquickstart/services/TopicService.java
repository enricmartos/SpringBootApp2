package enricmartos.springbootquickstart.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enricmartos.springbootquickstart.dao.TopicRepository;
import enricmartos.springbootquickstart.models.Topic;

//Class that allows to deal with the CRUDrepository
@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
		//Getting a list from the iterable
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add); //Lambda expression
		return topics;
	}
	
	public Topic getTopic(Long id) {
		Optional<Topic> optionalTopic =  topicRepository.findById(id);
		Topic topic = optionalTopic.get();
		return topic;
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, Long id) {
		Topic topic_updated = new Topic(id, topic.getName(), topic.getDescription(), topic.getAttachment());
//		Topic topic_updated = new Topic(id, topic.getName(), topic.getDescription());
		topicRepository.save(topic_updated);
		
	}

	public void deleteTopic(Long id) {
		topicRepository.deleteById(id);
		
	}
	
	

}
