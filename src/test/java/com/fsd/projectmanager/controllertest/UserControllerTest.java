package com.fsd.projectmanager.controllertest;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fsd.projectmanager.controller.UserController;
import com.fsd.projectmanager.entity.User;
import com.fsd.projectmanager.model.UserModel;
import com.fsd.projectmanager.service.UserService;
import com.fsd.projectmanager.util.TestUtils;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

    @InjectMocks
    public UserController userController;

    @Mock
    public UserService userService;

    @Test
    public void saveUserTest(){

        Mockito.when(userService.addUser(Mockito.any(User.class))).thenReturn(TestUtils.getUser());
        User output = userController.addUser(TestUtils.getUserModel());

        Assert.assertEquals(TestUtils.getUser().getUserId(), output.getUserId());

    }

    @Test
    public void getAllUsersTest(){

        Mockito.when(userService.viewUsers()).thenReturn(TestUtils.getUserList());

        List<UserModel> output = userController.viewUsers();

        Assert.assertEquals(2, output.size());
    }

    @Test
    public void editUserTest(){

    	   Mockito.when(userService.addUser(Mockito.any(User.class))).thenReturn(TestUtils.getUser());
        User output = userController.editUser(TestUtils.getUserModel());

        Assert.assertEquals(TestUtils.getUser().getUserId(),output.getUserId());
        Assert.assertEquals(TestUtils.getUser().getFirstName(),output.getFirstName());
        Assert.assertEquals(TestUtils.getUser().getLastName(),output.getLastName());
        Assert.assertEquals(TestUtils.getUser().getEmployeeId(),output.getEmployeeId());
    }

    @Test
    public void deleteUserTest(){

        Mockito.when(userService.deleteUser(Mockito.anyInt())).thenReturn("User deleted successfully");

        String output = userController.deleteUser(1);

        Assert.assertEquals("User deleted successfully", output);
    }
}
