package com.fsd.projectmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.projectmanager.entity.User;
import com.fsd.projectmanager.model.UserModel;
import com.fsd.projectmanager.service.UserService;



@RestController
@RequestMapping("/projectmanager/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public User addUser( @RequestBody UserModel userModel) {
		
		User newUser = new User();
		newUser.setFirstName(userModel.getFirstName());
		newUser.setLastName(userModel.getLastName());
		newUser.setEmployeeId(userModel.getEmployeeID());
	return 	userService.addUser(newUser);
	}
	@PostMapping("/editUser")
	public User editUser( @RequestBody UserModel userModel) {
		
		User user = new User();
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setEmployeeId(userModel.getEmployeeID());
		user.setUserId(userModel.getUserID());
	return 	userService.addUser(user);
	}
	@GetMapping("/viewUsers")
	public List<UserModel> viewUsers() {
		List<UserModel> userList=new ArrayList<UserModel>() ;
		userService.viewUsers().forEach(item->{
			UserModel userModel=new UserModel();
			userModel.setFirstName(item.getFirstName());
			userModel.setLastName(item.getLastName());
			userModel.setEmployeeID(item.getEmployeeId());
			userModel.setUserID(item.getUserId());
			userList.add(userModel);
		});
	return 	userList;
	}
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser( @PathVariable Integer userId) {
			return 	userService.deleteUser(userId);
	}
	
	

}
