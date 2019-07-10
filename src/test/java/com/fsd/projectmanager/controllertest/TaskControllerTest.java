package com.fsd.projectmanager.controllertest;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fsd.projectmanager.controller.TaskController;
import com.fsd.projectmanager.entity.ParentTask;
import com.fsd.projectmanager.entity.Task;
import com.fsd.projectmanager.model.TaskModel;
import com.fsd.projectmanager.service.ProjectService;
import com.fsd.projectmanager.service.TaskService;
import com.fsd.projectmanager.util.TestUtils;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskControllerTest {

    @InjectMocks
    public TaskController taskController;

    @Mock
    public TaskService taskService;
    
    @Mock
    public ProjectService projectService;

    @Test
    public void saveTaskTest(){

        Mockito.when(taskService.addTask(Mockito.any(Task.class))).thenReturn(TestUtils.getTask());
        Mockito.when(taskService.addParentTask(Mockito.any(ParentTask.class))).thenReturn(TestUtils.getParentTask());
        Task output = taskController.addTask(TestUtils.getTaskModel());
        
        Assert.assertEquals(TestUtils.getTask().getTaskId(), output.getTaskId());

    }

    @Test
    public void getAllTasksTest(){

        Mockito.when(taskService.viewTasks()).thenReturn(TestUtils.getTaskList());
        
        Mockito.when(projectService.findProjectById(Mockito.anyInt())).thenReturn(TestUtils.getProject());

        List<TaskModel> output = taskController.viewTasks();

        Assert.assertEquals(2, output.size());
    }

    @Test
    public void editTaskTest(){
    	 Mockito.when(taskService.addTask(Mockito.any(Task.class))).thenReturn(TestUtils.getTask());
         Mockito.when(taskService.addParentTask(Mockito.any(ParentTask.class))).thenReturn(TestUtils.getParentTask());

    	 Task output = taskController.updateTask(TestUtils.getTaskModel());

         Assert.assertEquals(TestUtils.getTask().getTaskId(), output.getTaskId());

        Assert.assertEquals(TestUtils.getTask().getTaskId(),output.getTaskId());
        Assert.assertEquals(TestUtils.getTask().getTask(),output.getTask());
    }

    @Test
    public void endTask(){
    	
    	  Mockito.when(taskService.addTask(Mockito.any(Task.class))).thenReturn(TestUtils.getTask());
         
    	  Task output = taskController.endTask(TestUtils.getTaskModel());

          Assert.assertEquals(TestUtils.getTask().getTaskId(), output.getTaskId());
    }
}
