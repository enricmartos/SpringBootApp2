package enricmartos.springbootquickstart.controllers.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import enricmartos.springbootquickstart.models.Course;
import enricmartos.springbootquickstart.models.Topic;
import enricmartos.springbootquickstart.services.CourseService;
import enricmartos.springbootquickstart.services.TopicService;

@RestController
public class CourseRestController {
	
	//This annotation says that the attribute needs Dependency Injection
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable Long id) {
		return courseService.getAllCourses(id);
	}
	
	//Variables en les URL's->curly braces
	@RequestMapping("/topics/{topicId}/courses/{id}")
	//Avisem que id és una variable del Path->Recomanable posar el mateix nom tant el path com a l'argument
	public Course getCourse(@PathVariable Long id) {
		return courseService.getCourse(id);
	}
	
	//@RequestMapping(method=RequestMethod.POST, value ="/topics/{topicId}/courses", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@RequestMapping(method=RequestMethod.POST, value ="/topics/{topicId}/courses")
	//@Request body indica que la instància de course prové del cos de la petició 
	public void addCourse(@RequestBody Course course, @PathVariable Long topicId) {
	//public void addCourse(@RequestParam("file") MultipartFile file) throws IOException {
	//public void addCourse(@RequestBody Course course, @PathVariable Long topicId, @RequestParam("file") MultipartFile file) throws IOException {
		//writeFile(file);
		
		Topic topic = topicService.getTopic(topicId);
		course.setTopic(topic);
		//course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
		
	}
	
	public void writeFile(MultipartFile file) throws IOException {
		File convertFile = new File("C:\\Users\\Enri\\Documents\\workspace-sts-3.9.4.RELEASE\\SpringBootApp2\\src\\main\\resources"
				+ "\\static\\img\\uploaded_img\\" + file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value ="/topics/{topicId}/courses/{id}")
	//@Request body indica que la instància de course prové del cos de la petició 
	public void updateCourse(@RequestBody Course course, @PathVariable Long topicId, @PathVariable Long id) {
		Topic topic = topicService.getTopic(topicId);
		course.setTopic(topic);
		//course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value ="/topics/{topicId}/courses/{id}")
	//Avisem que id és una variable del Path->Recomanable posar el mateix nom tant el path com a l'argument
	public void deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
	}

}
