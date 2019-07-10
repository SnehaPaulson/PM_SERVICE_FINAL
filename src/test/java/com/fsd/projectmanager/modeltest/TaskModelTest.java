package com.fsd.projectmanager.modeltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fsd.projectmanager.model.TaskModel;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskModelTest {
	
	@Test
	public void testUserRecord() {
		TaskModel test = new com.fsd.projectmanager.model.TaskModel();
		test.setTask("Task");
		assertEquals("Task",test.getTask());
		test.setTaskID(1);
		assertEquals(Integer.valueOf(1),test.getTaskID());
	}

}
