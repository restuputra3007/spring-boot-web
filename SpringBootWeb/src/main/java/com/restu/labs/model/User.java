package com.restu.labs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2898508252599667663L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private long id;
	
	@Column(name="email")
	@Email(message="*Please provide a valid Email")
	@NotEmpty(message="*Please provide an Email")
	private String email;
	
	@Column(name="name")
	@NotEmpty(message="*Please provide your name")
	private String name;
	
	@Column(name="last_name")
	@NotEmpty(message="*Please provide your last name")
	private String lastName;
	
	@Column(name="password")
	@NotEmpty(message="*Please provide your password")
	@Length(min=5,message="Your password must have at least 5 characters")
	private String password;
	
	@Column(name="active")
	private int active;
	
	//@ManyToMany(cascade=CascadeType.ALL)
	//@JoinTable(name="user_role",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role roles;
	
	@Transient
	private String nameRole;
	
	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public long getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getActive() {
		return active;
	}
	
	public void setActive(int active) {
		this.active = active;
	}
	
	public Role getRoles() {
		return roles;
	}
	
	public void setRoles(Role roles) {
		this.roles = roles;
	}
	
	public String toString() {
		return "Email : "+getEmail()+"Role id :"+getRoles().getId()+"Role name : "+getRoles().getRole();
	}
}
