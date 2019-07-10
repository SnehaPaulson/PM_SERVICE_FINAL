package com.fsd.projectmanager.modeltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fsd.projectmanager.model.ProjectModel;
import com.fsd.projectmanager.model.UserModel;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectModelTest {
	
	@Test
	public void testUserRecord() {
		ProjectModel test = new ProjectModel();
		test.setProject("project");
		assertEquals("project",test.getProject());
		test.setProjectID(1);
		assertEquals(Integer.valueOf(1),test.getProjectID());
	}

}
