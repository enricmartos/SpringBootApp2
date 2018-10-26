package enricmartos.springbootquickstart.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import enricmartos.springbootquickstart.models.Course;


public interface CourseRepository extends CrudRepository<Course, Long> {
	
	//interface->just method declarations
	//takes a topicId and returns its list of courses
	
	
	//Custom "find" methods must follow this pattern and spring does the queries:
	//findBy + ${property} if the prop is a String
	//Example
	//public List<Course> findByTopic(String name);
	//findBy + ${property: Entity name} + ${property: Entity field}  if the prop is an Entity
	public List<Course> findByTopicId(Long topicId);
	

}
