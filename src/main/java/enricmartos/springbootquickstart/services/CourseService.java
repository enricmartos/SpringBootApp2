package enricmartos.springbootquickstart.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enricmartos.springbootquickstart.dao.CourseRepository;
import enricmartos.springbootquickstart.models.Course;
import enricmartos.springbootquickstart.models.Topic;

//Class that allows to deal with the CRUDrepository
@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(Long topicId) {
		//Getting a list from the iterable
		//Find the courses that belong to a particular topic
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add); //Lambda expression
		return courses;
	}
	
	public Course getCourse(Long id) {	
		Optional<Course> optionalCourse =  courseRepository.findById(id);
		Course course = optionalCourse.get();
		return course;
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course, Long id) {
		//Course course_updated = new Course(id, course.getName(), course.getDescription(), course.getAttachment(), course.getTopic());
		Course course_updated = new Course(id, course.getName(), course.getDescription(), course.getTopic());
		courseRepository.save(course_updated);
		
	}

	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
		
	}
	
	

}
