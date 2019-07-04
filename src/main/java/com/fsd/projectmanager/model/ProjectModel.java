package com.fsd.projectmanager.model;

import java.util.Date;

public class ProjectModel {
	private Integer projectID;
	private String project;
	private String manager;
	private Integer priority;
	private Date startDate;
	private Date endDate;
	private Boolean activeFlag=true;
	private Integer noOfTasks;
	private Integer completedTasks;
	public ProjectModel() {
		super();
	}

	public ProjectModel(Integer projectID, String project, String manager, Integer priority, Date startDate,
			Date endDate, Boolean activeFlag, Integer noOfTasks, Integer completedTasks) {
		super();
		this.projectID = projectID;
		this.project = project;
		this.manager = manager;
		this.priority = priority;
		this.startDate = startDate;
		this.endDate = endDate;
		this.activeFlag = activeFlag;
		this.noOfTasks = noOfTasks;
		this.completedTasks = completedTasks;
	}




	public Integer getNoOfTasks() {
		return noOfTasks;
	}

	public void setNoOfTasks(Integer noOfTasks) {
		this.noOfTasks = noOfTasks;
	}

	public Integer getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(Integer completedTasks) {
		this.completedTasks = completedTasks;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}


	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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
	
	

}
