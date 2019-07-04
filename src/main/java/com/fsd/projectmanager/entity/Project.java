package com.fsd.projectmanager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name="Project")
public class Project {

	@Id
	@Column(name="Project_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer projectId;
	
	
	@Column(name="Project")
	@Size(min=3, max=50)
	private String project;
	
	@Column(name="Manager")
	@Size(min=3, max=50)
	private String manager;
	
	@Column(name="Start_Date")
	@Type(type="date")
	private Date startDate;
	
	@Column(name="End_Date")
	@Type(type="date")
	private Date endDate;
	
	@Column(name="Priority")
	private Integer priority;
	
	@Column(name="Active_Flag")
	private Boolean activeFlag;
	
	

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	
	
}
