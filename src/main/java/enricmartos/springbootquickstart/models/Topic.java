package enricmartos.springbootquickstart.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//Apache Derby: Embedded db that clears everything when killing the server
@Entity(name = "topic")
public class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name; 
	
	@Column(name = "description")
	private String description;
	
	//@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	//private List<Course> courses  = new ArrayList<>();
	
	//Foreign Key
	@JoinColumn(name = "attachment_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Attachment attachment;
	
	public Topic() {
		
	}
	
//	public Topic(Long id, String name, String description) {
	public Topic(Long id, String name, String description, Attachment attachment) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.attachment = attachment;
	}
	
	public Topic(String name, String description, Attachment attachment) {
		this.name = name;
		this.description = description;
		this.attachment = attachment;
	}
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	

	/*
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	*/
	
	

}
