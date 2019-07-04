package com.fsd.projectmanager.controllertest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fsd.projectmanager.controller.UserController;
import com.fsd.projectmanager.entity.User;
import com.fsd.projectmanager.model.UserModel;
import com.fsd.projectmanager.service.UserService;
import  com.fsd.projectmanager.util.TestUtils;

@RunWith(SpringRunner.class)
@WebMvcTest(value=UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void viewUsers_Test() throws Exception{
		UserModel userModel=TestUtils.getUserModel();
		List<UserModel> userModelList = new ArrayList<UserModel>();
		userModelList.add(userModel);
		User  user=TestUtils.getUser();
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		Mockito.when(userService.viewUsers()).thenReturn(userList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/projectmanager/user/viewUsers").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String actualResult= result.getResponse().getContentAsString();
		System.out.println("actualResult::"+actualResult);
		String expected = TestUtils.serializeObjectAsJsonString(userModelList);
		System.out.println("EXPECTED::"+userModelList);
		JSONAssert.assertEquals(expected, actualResult, false);

	}
	
	@Test
	public void addUser_Test() throws Exception{
		UserModel userModel=TestUtils.getUserModel();
		User  user=TestUtils.getUser();
		String userJson=TestUtils.serializeObjectAsJsonString(user);
		Mockito.when(userService.addUser(Mockito.any(User.class))).thenReturn(user);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/projectmanager/user/addUser").accept(MediaType.TEXT_PLAIN_VALUE)
				.content(userJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String actualResult= result.getResponse().getContentAsString();
		String expected = TestUtils.serializeObjectAsJsonString(userModel);
		JSONAssert.assertEquals(expected, actualResult, false);

	}

}
