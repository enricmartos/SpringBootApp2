package enricmartos.springbootquickstart.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import enricmartos.springbootquickstart.models.Attachment;
import enricmartos.springbootquickstart.models.Topic;
import enricmartos.springbootquickstart.services.AttachmentService;
import enricmartos.springbootquickstart.services.TopicService;

@Controller
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private AttachmentService attachService;
	
	private MultipartFile file;
	
	//TOPIC CRUD OPERATIONS
	//READ TOPICS
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String init(HttpServletRequest req) {
		req.setAttribute("topics", topicService.getAllTopics());
		req.setAttribute("mode", "TOPIC_VIEW");
		return "index"; 
	}
	
	//CREATE TOPIC 
	@GetMapping("/newTopic")
	public String newBook(HttpServletRequest req) {
		req.setAttribute("file", "file");
		req.setAttribute("mode", "TOPIC_NEW");
		return "index";
	}
	
	@RequestMapping(value ="/save", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	//@Request body indica que la instància de topic prové del cos de la petició 
	public void addTopic(@ModelAttribute Topic topic, @RequestParam("file") MultipartFile file, HttpServletRequest req, HttpServletResponse res) throws IOException {
		if (file.isEmpty()) {
			Topic topicStored = topicService.getTopic(topic.getId());
			Attachment attach = topicStored.getAttachment();
			String attachName = attach.getName();
			System.out.println("Current Attachment: " + attachName);
			topic.setAttachment(attach);
			topicService.addTopic(topic);
		} else {
			String fileNameComplete = file.getOriginalFilename();
			String[] parts = fileNameComplete.split(Pattern.quote("."));
			String name = parts[0]; 
			String extension = parts[1];
			
			Attachment attach = new Attachment(name, extension);
			attachService.addAttachment(attach);
			
			topic.setAttachment(attach);
			topicService.addTopic(topic);
			writeFile(file);
		}
		
//		String fileNameComplete = file.getOriginalFilename();
//		String[] parts = fileNameComplete.split(Pattern.quote("."));
//		String name = parts[0]; 
//		String extension = parts[1]; 
//		
//		Attachment attach = new Attachment(name, extension);
//		attachService.addAttachment(attach);
//		topic.setAttachment(attach);
//		topicService.addTopic(topic);
//		writeFile(file);
		req.setAttribute("topics", topicService.getAllTopics());
		req.setAttribute("mode", "TOPIC_VIEW");
		
		res.sendRedirect("/");
	}
	
	public void writeFile(MultipartFile file) throws IOException {
		File convertFile = new File("C:\\Users\\Enri\\Documents\\workspace-sts-3.9.4.RELEASE\\SpringBootApp2\\src\\main\\resources"
				+ "\\static\\img\\uploaded_img\\" + file.getOriginalFilename());
		convertFile.createNewFile();
		
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
	}
	
	//UPDATE TOPIC
	@GetMapping("/updateTopic")
	public String init(@RequestParam long id, HttpServletRequest req ) {
		Topic topic = topicService.getTopic(id);
		
		req.setAttribute("topic", topic );
		req.setAttribute("mode", "TOPIC_EDIT");
		
		return "index"; 
	}
	
	//DELETE TOPIC
	@GetMapping("/deleteTopic")
	public void deleteBook(@RequestParam long id, HttpServletRequest req, HttpServletResponse res) throws IOException {
		topicService.deleteTopic(id);
		
		res.sendRedirect("/");
	}
	
}
