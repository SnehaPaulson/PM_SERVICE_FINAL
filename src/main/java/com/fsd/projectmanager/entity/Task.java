package com.fsd.projectmanager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name="task")
public class Task {

	@Id
	@Column(name="Task_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer taskId;
	
	@Column(name="Parent_ID")
	private Integer parentId;
	
	@Column(name="Project_ID")
	private Integer projectId;
	
	@Column(name="User_ID")
	private Integer userId;
	
	@Column(name="Task")
	@Size(min=3, max=50)
	private String task;
	
	@Column(name="Start_Date")
	@Type(type="date")
	private Date startDate;
	
	@Column(name="End_Date")
	@Type(type="date")
	private Date endDate;
	
	@Column(name="Priority")
	private Integer priority;
	
	@ManyToOne()
	@JoinColumn(name="Parent_ID", insertable=false, updatable=false)
	private ParentTask parentTask;
	
	@ManyToOne()
	@JoinColumn(name="Project_ID", insertable=false, updatable=false)
	private Project project;
	
	@Column(name="Active_Flag")
	private Boolean activeFlag;
	
	

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
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

	public ParentTask getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}
	
	
}
