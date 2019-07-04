package com.fsd.projectmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.projectmanager.entity.ParentTask;
import com.fsd.projectmanager.entity.Project;
import com.fsd.projectmanager.entity.Task;
import com.fsd.projectmanager.model.TaskModel;
import com.fsd.projectmanager.service.ProjectService;
import com.fsd.projectmanager.service.TaskService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/projectmanager/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/addTask")
	public Task addTask( @RequestBody TaskModel taskModel) {
		
		Task newTask = new Task();
		newTask.setTask(taskModel.getTask());
		newTask.setStartDate(taskModel.getStartDate());
		newTask.setEndDate(taskModel.getEndDate());
		newTask.setPriority(taskModel.getPriority());
		newTask.setActiveFlag(true);
		newTask.setUserId(taskModel.getUserID());
		newTask.setProjectId(taskModel.getProjectID());
		if(null!=taskModel.getParentTask() && !"".equals(taskModel.getParentTask())) {
		ParentTask newParentTask = new ParentTask();
		newParentTask.setParentTask(taskModel.getParentTask());
		newParentTask.setParentId(taskModel.getParentTaskID());
		newParentTask = taskService.addParentTask(newParentTask);
		newTask.setParentId(newParentTask.getParentId());
		}
	return 	taskService.addTask(newTask);
	}
	@PostMapping("/updateTask")
	public Task upadteTask( @RequestBody TaskModel taskModel) {
		
		Task task = new Task();
		task.setActiveFlag(true);
		task.setTask(taskModel.getTask());
		task.setStartDate(taskModel.getStartDate());
		task.setEndDate(taskModel.getEndDate());
		task.setPriority(taskModel.getPriority());
		task.setTaskId(taskModel.getTaskID());
		task.setUserId(taskModel.getUserID());
		task.setProjectId(taskModel.getProjectID());
		if(null!=taskModel.getParentTask() && !"".equals(taskModel.getParentTask())) {
		ParentTask newParentTask = new ParentTask();
		newParentTask.setParentTask(taskModel.getParentTask());
		newParentTask.setParentId(taskModel.getParentTaskID());
		newParentTask = taskService.addParentTask(newParentTask);
		task.setParentId(newParentTask.getParentId());
		}
	return 	taskService.addTask(task);
	}
	@GetMapping("/viewTasks")
	public List<TaskModel> viewTasks() {
		List<TaskModel> taskList=new ArrayList<TaskModel>() ;
		taskService.viewTasks().forEach(item->{
			TaskModel taskmodel=new TaskModel();
			taskmodel.setTask(item.getTask());
			taskmodel.setPriority(item.getPriority());
			taskmodel.setStartDate(item.getStartDate());
			taskmodel.setEndDate(item.getEndDate());
			taskmodel.setTaskID(item.getTaskId());
			taskmodel.setUserID(item.getUserId());
			taskmodel.setProjectID(item.getProjectId());
			if(null!=item.getParentTask()) {
			taskmodel.setParentTaskID(item.getParentTask().getParentId());
			taskmodel.setParentTask(item.getParentTask().getParentTask());
			}
			taskmodel.setActiveFlag(item.getActiveFlag());
			Project project = 	projectService.findProjectById(item.getProjectId());
			taskmodel.setProject(project.getProject());
			taskList.add(taskmodel);
		});
	return 	taskList;
	}
	@PostMapping("/endTask")
	public Task endTask( @RequestBody TaskModel taskModel) {
		
		Task task = new Task();
		task.setTask(taskModel.getTask());
		task.setStartDate(taskModel.getStartDate());
		task.setEndDate(taskModel.getEndDate());
		task.setPriority(taskModel.getPriority());
		task.setTaskId(taskModel.getTaskID());
		task.setParentId(taskModel.getParentTaskID());
		task.setUserId(taskModel.getUserID());
		task.setProjectId(taskModel.getProjectID());
		task.setActiveFlag(false);
	return 	taskService.addTask(task);
	}
	
	@GetMapping("/validateParentTask/{task}")
	public Integer validateParentTask( @PathVariable String task ) {
		
	Task taskData = 	taskService.validateParentTask(task);
	return taskData.getTaskId();
	}

}
