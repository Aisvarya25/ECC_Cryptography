package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class Files {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "descr")
	private String descr;
	
	@Column(name = "file_name")
	private String file_name;

	public Files() {
		
	}
	
	public Files(String emailId, String descr, String fileName) {
		super();
		this.emailId = emailId;
		this.descr = descr;
		this.file_name = file_name;		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getDesct() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr =descr;
	}
	
	public String getFileName() {
		return file_name;
	}
	public void setFileName(String file_name) {
		// String file_name = "C:\\fakepath\\do.txt";
	        file_name= file_name.substring(file_name.lastIndexOf("\\")+1, file_name.length());
	     //   System.out.println(file_name);
		this.file_name = file_name;
	}
	
	
}
