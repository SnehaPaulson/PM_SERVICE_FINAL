package com.fsd.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.projectmanager.entity.ParentTask;
import com.fsd.projectmanager.entity.Task;
import com.fsd.projectmanager.repository.ParentTaskRepository;
import com.fsd.projectmanager.repository.TaskRepository;

@Service("taskService")
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ParentTaskRepository parentTaskRepository;

	public Task addTask(Task task) {
		return this.taskRepository.save(task);
	}

	public List<Task> viewTasks() {
		return this.taskRepository.findAll();
	}

	public ParentTask addParentTask(ParentTask newParentTask) {
		return this.parentTaskRepository.save(newParentTask);
	}

	public Task validateParentTask(String task) {
		return this.taskRepository.findTaskIdByTask(task);
	}

	public Integer getTaskCount(Integer projectId) {
		return this.taskRepository.getTaskCount(projectId);
		
	}

	public Integer getCompletedTasksCount(Integer projectId) {
		return this.taskRepository.getCompletedTasksCount(projectId);
	}
}
