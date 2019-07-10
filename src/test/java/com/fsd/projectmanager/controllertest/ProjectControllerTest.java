package com.fsd.projectmanager.controllertest;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fsd.projectmanager.controller.ProjectManagerController;
import com.fsd.projectmanager.entity.Project;
import com.fsd.projectmanager.model.ProjectModel;
import com.fsd.projectmanager.service.ProjectService;
import com.fsd.projectmanager.service.TaskService;
import com.fsd.projectmanager.util.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectControllerTest {

    @InjectMocks
    public ProjectManagerController ProjectController;

    @Mock
    public ProjectService ProjectService;
    
    @Mock
    public TaskService taskService;

    @Test
    public void saveProjectTest(){

        Mockito.when(ProjectService.addProject(Mockito.any(Project.class))).thenReturn(TestUtils.getProject());
        Project output = ProjectController.addProject(TestUtils.getProjectModel());

        Assert.assertEquals(TestUtils.getProject().getProjectId(), output.getProjectId());

    }

    @Test
    public void getAllProjectsTest(){

        Mockito.when(ProjectService.viewProjects()).thenReturn(TestUtils.getProjectList());
        
        Mockito.when(taskService.getCompletedTasksCount(Mockito.anyInt())).thenReturn(1);
        
        Mockito.when(taskService.getTaskCount(Mockito.anyInt())).thenReturn(1);

        List<ProjectModel> output = ProjectController.viewProjects();

        Assert.assertEquals(2, output.size());
    }
    
    @Test
    public void editProjectTest(){

    	  Mockito.when(ProjectService.addProject(Mockito.any(Project.class))).thenReturn(TestUtils.getProject());
          Project output = ProjectController.editProject(TestUtils.getProjectModel());

          Assert.assertEquals(TestUtils.getProject().getProjectId(), output.getProjectId());

          Assert.assertEquals(TestUtils.getProject().getProject(),output.getProject());
    }

    @Test
    public void deleteProjectTest(){

        Mockito.when(ProjectService.deleteProject(Mockito.anyInt())).thenReturn("Project deleted successfully");

        String output = ProjectController.deleteProject(1);

        Assert.assertEquals("Project deleted successfully", output);
    }
}
