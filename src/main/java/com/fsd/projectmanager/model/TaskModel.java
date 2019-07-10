package com.fsd.projectmanager.model;

import java.util.Date;

public class TaskModel {

	private Integer taskID;
	private Integer parentTaskID;
	private String task;
	private String parentTask;
	private Date startDate;
	private Date endDate;
	private Integer priority;
	private Boolean activeFlag=true;
	private Integer projectID;
	private Integer userID;
	private String project;
	
	public TaskModel() {
		super();
	}


	
	public TaskModel(Integer taskID, Integer parentTaskID, String task, String parentTask, Date startDate, Date endDate,
			Integer priority, Boolean activeFlag, Integer projectID, Integer userID) {
		super();
		this.taskID = taskID;
		this.parentTaskID = parentTaskID;
		this.task = task;
		this.parentTask = parentTask;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.activeFlag = activeFlag;
		this.projectID = projectID;
		this.userID = userID;
	}


	public Integer getProjectID() {
		return projectID;
	}


	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}


	public Integer getUserID() {
		return userID;
	}


	public void setUserID(Integer userID) {
		this.userID = userID;
	}


	public Boolean getActiveFlag() {
		return activeFlag;
	}



	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}



	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getParentTask() {
		return parentTask;
	}
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
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

	public Integer getTaskID() {
		return taskID;
	}

	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}

	public Integer getParentTaskID() {
		return parentTaskID;
	}

	public void setParentTaskID(Integer parentTaskID) {
		this.parentTaskID = parentTaskID;
	}


	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}
	
	
	
}
