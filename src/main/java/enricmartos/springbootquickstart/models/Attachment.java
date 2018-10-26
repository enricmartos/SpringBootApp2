package enricmartos.springbootquickstart.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "attachment")
public class Attachment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name; 
	
	@Column(name = "extension")
	private String extension;
	
	
//	//Foreign Key
//	@JoinColumn(name = "topic_id")
//	@OneToOne
//	private Topic topic;
	
//	public Attachment(Long id, String name, String extension, Topic topic) {
	public Attachment(Long id, String name, String extension) {
		this.id = id;
		this.name = name;
		this.extension = extension;
		//this.topic = topic;
	}
	
	public Attachment() {
		
	}
	
//	public Attachment(String name, String extension, Topic topic) {
	public Attachment(String name, String extension) {
		this.name = name;
		this.extension = extension;
//		this.topic = topic;
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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
//	public Topic getTopic() {
//		return topic;
//	}
//
//	public void setTopic(Topic topic) {
//		this.topic = topic;
//	}
	
	
	

}
