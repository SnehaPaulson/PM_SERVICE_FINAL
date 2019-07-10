package com.fsd.projectmanager.servicetest;



import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fsd.projectmanager.entity.User;
import com.fsd.projectmanager.repository.UserRepository;
import com.fsd.projectmanager.service.UserService;
import com.fsd.projectmanager.util.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @InjectMocks
    public UserService userService;

    @Mock
    public UserRepository userRepository;

    @Test
    public void addUserTest(){
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(TestUtils.getUser());
        User output = userService.addUser(TestUtils.getUser());

        Assert.assertEquals(TestUtils.getUser().getUserId(),output.getUserId());
    }


    @Test
    public void deleteUserTest(){
        String output = userService.deleteUser(1);
        Assert.assertEquals("User deleted successfully", output);
    }

    @Test
    public void viewUsersTest(){
        Mockito.when(userRepository.findAll()).thenReturn(TestUtils.getUserList());
        List<User> output = userService.viewUsers();
        Assert.assertEquals(2,output.size());
    }
    
 
    

    

}
