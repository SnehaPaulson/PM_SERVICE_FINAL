package com.fsd.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.projectmanager.entity.Project;
import com.fsd.projectmanager.repository.ProjectRepository;

@Service("projectService")
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	

	public Project addProject(Project project) {
		return this.projectRepository.save(project);
	}

	public List<Project> viewProjects() {
		return this.projectRepository.findAll();
	}

	public String deleteProject(Integer projectId) {
			try {
				this.projectRepository.deleteById(projectId);
				return "Project deleted successfully";
			} catch (Exception e) {
				return "Error while deleting user";
			}
		}

	public Project findProjectById(Integer projectId) {
		return this.projectRepository.findByProjectId(projectId);
	}

	

}
