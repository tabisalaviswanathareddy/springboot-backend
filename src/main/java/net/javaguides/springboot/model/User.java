package net.javaguides.springboot.model;


import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Document(collection="user")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
@Scope(value ="session")
@Component
public class User {
	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";
	@Id
	@Indexed(unique = true)
	private int id;


	
	private String firstName;

	private String lastName;
	
	private String emailId;

	private String userName;

	private String password;

	private String role;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String emailId, String userName, String password, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
