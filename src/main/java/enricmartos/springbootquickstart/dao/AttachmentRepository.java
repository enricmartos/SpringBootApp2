package enricmartos.springbootquickstart.dao;

import org.springframework.data.repository.CrudRepository;

import enricmartos.springbootquickstart.models.Attachment;

public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
	
	//Standard CRUD operations provided by this JPA interface
	//It requires 2 generic types to do these operations (string (long is also used)-> id, and the entity)
	//getAllTopics()
	//getTopic(String Id)
	//updateTopic(Topic t)
	//deleteTopic(String id)
	

}
