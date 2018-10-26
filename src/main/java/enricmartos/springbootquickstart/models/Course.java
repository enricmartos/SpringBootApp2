package enricmartos.springbootquickstart.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

//Apache Derby: Embedded db that clears everything when killing the server
@Entity(name ="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(name = "name")
	private String name; 
	
	@Column(name = "description")
	private String description;
	
	//Foreign Key
	@JoinColumn(name = "topic_id")
	@ManyToOne
	private Topic topic;
	
	/*
	//Foreign Key
	@JoinColumn(name = "attachment_id")
	@OneToOne
	private Attachment attachment;
	*/
	
	public Course() {
		
	}
	
	//public Course(Long id, String name, String description, Attachment attachment, Topic topic) {
	public Course(Long id,String name, String description, Topic topic) {
		this.id = id;
		this.name = name;
		this.description = description;
		//this.topic = new Topic(topicId, "", "");
		//this.attachment = attachment;
		this.topic = topic;
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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	/*
	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	*/
	

}
