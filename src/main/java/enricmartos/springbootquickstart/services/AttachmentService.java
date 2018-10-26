package enricmartos.springbootquickstart.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enricmartos.springbootquickstart.dao.AttachmentRepository;
import enricmartos.springbootquickstart.models.Attachment;

@Service
public class AttachmentService {
	
	@Autowired
	private AttachmentRepository attachmentRepository;
	
	public List<Attachment> getAllAttachments() {
		//Getting a list from the iterable
		List<Attachment> attachments = new ArrayList<>();
		attachmentRepository.findAll()
		.forEach(attachments::add); //Lambda expression
		return attachments;
	}
	
	public Attachment getAttachment(Long id) {
		Optional<Attachment> optionalAttach =  attachmentRepository.findById(id);
		Attachment attach = optionalAttach.get();
		return attach;
	}
	
	public void addAttachment(Attachment attach) {
		attachmentRepository.save(attach);
	}

	public void updateAttachment(Attachment attach, Long id) {
		Attachment attach_updated = new Attachment(id, attach.getName(), attach.getExtension());
//		Topic topic_updated = new Topic(id, topic.getName(), topic.getDescription());
		attachmentRepository.save(attach_updated);
		
	}

	public void deleteAttachment(Long id) {
		attachmentRepository.deleteById(id);
		
	}

}
