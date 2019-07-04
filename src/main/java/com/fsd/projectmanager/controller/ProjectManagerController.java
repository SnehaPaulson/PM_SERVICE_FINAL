package com.fsd.projectmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.projectmanager.entity.Project;
import com.fsd.projectmanager.model.ProjectModel;
import com.fsd.projectmanager.service.ProjectService;
import com.fsd.projectmanager.service.TaskService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/projectmanager/project")
public class ProjectManagerController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/addProject")
	public Project addProject( @RequestBody ProjectModel projectModel) {
		
		Project newProject = new Project();
		newProject.setProject(projectModel.getProject());
		newProject.setStartDate(projectModel.getStartDate());
		newProject.setEndDate(projectModel.getEndDate());
		newProject.setPriority(projectModel.getPriority());
		newProject.setManager(projectModel.getManager());
		newProject.setActiveFlag(true);
	return 	projectService.addProject(newProject);
	}
	@PostMapping("/editProject")
	public Project editProject( @RequestBody ProjectModel projectModel) {
		
		Project project = new Project();
		project.setProject(projectModel.getProject());
		project.setManager(projectModel.getManager());
		project.setStartDate(projectModel.getStartDate());
		project.setEndDate(projectModel.getEndDate());
		project.setPriority(projectModel.getPriority());
		project.setProjectId(projectModel.getProjectID());
		project.setActiveFlag(true);
	return 	projectService.addProject(project);
	}
	@GetMapping("/viewProjects")
	public List<ProjectModel> viewProjects() {
		List<ProjectModel> projectList=new ArrayList<ProjectModel>() ;
		projectService.viewProjects().forEach(item->{
			ProjectModel projectModel=new ProjectModel();
			projectModel.setProject(item.getProject());
			projectModel.setPriority(item.getPriority());
			projectModel.setStartDate(item.getStartDate());
			projectModel.setEndDate(item.getEndDate());
			projectModel.setProjectID(item.getProjectId());
			projectModel.setManager(item.getManager());
			projectModel.setActiveFlag(item.getActiveFlag());
			projectModel.setNoOfTasks(taskService.getTaskCount(item.getProjectId()));
			projectModel.setCompletedTasks(taskService.getCompletedTasksCount(item.getProjectId()));
			projectList.add(projectModel);
		});
	return 	projectList;
	}
	@DeleteMapping("/deleteProject/{projectId}")
	public String deleteProject( @PathVariable Integer projectId) {
			return 	projectService.deleteProject(projectId);
	}
	
	

}
