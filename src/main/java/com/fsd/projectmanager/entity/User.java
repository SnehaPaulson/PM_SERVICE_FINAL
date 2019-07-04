package com.fsd.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="User_ID",nullable=false)
	Integer userId;
	
	@Column(name="First_Name")
	String firstName;
	
	@Column(name="Last_Name")
	String lastName;
	
	@Column(name="Employee_ID")
	Integer employeeId;
	
	@ManyToOne()
	@JoinColumn(name="Project_ID", insertable=false, updatable=false)
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="Task_ID", insertable=false, updatable=false)
	private Task task;

	
	public User() {
		super();
	}

	public User(Integer userId, String firstName, String lastName, Integer employeeId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
		}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	@Override
	public String toString() {
		return String.format("User [userId=%s, firstName=%s, lastName=%s, employeeId=%s]", userId, firstName, lastName,
				employeeId);
	}	
	
	
}
