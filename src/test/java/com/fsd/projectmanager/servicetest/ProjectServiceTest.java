package com.fsd.projectmanager.servicetest;



import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fsd.projectmanager.entity.Project;
import com.fsd.projectmanager.repository.ProjectRepository;
import com.fsd.projectmanager.service.ProjectService;
import com.fsd.projectmanager.util.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectServiceTest {

    @InjectMocks
    public ProjectService projectService;

    @Mock
    public ProjectRepository projectRepository;

    @Test
    public void addProjectTest(){
        Mockito.when(projectRepository.save(Mockito.any(Project.class))).thenReturn(TestUtils.getProject());
        Project output = projectService.addProject(TestUtils.getProject());

        Assert.assertEquals(TestUtils.getProject().getProjectId(),output.getProjectId());
    }


    @Test
    public void deleteProjectTest(){
        String output = projectService.deleteProject(1);
        Assert.assertEquals("Project deleted successfully", output);
    }

    @Test
    public void viewProjectsTest(){
        Mockito.when(projectRepository.findAll()).thenReturn(TestUtils.getProjectList());
        List<Project> output = projectService.viewProjects();
        Assert.assertEquals(2,output.size());
    }
    
 
    

    

}
