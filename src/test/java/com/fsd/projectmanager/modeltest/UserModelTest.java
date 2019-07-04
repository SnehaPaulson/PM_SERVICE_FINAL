package com.fsd.projectmanager.modeltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fsd.projectmanager.model.UserModel;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserModelTest {
	
	@Test
	public void testUserRecord() {
		UserModel test = new UserModel();
		test.setFirstName("sneha");;
		assertEquals("sneha",test.getFirstName());
		test.setUserID(1);
		assertEquals(Integer.valueOf(1),test.getUserID());
	}

}
