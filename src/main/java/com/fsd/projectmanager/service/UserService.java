package com.fsd.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.projectmanager.entity.User;
import com.fsd.projectmanager.repository.UserRepository;

@Service("userService")
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		return this.userRepository.save(user);
	}

	public List<User> viewUsers() {
		return this.userRepository.findAll();
	}

	public String deleteUser(Integer userId) {
		try {
			this.userRepository.deleteById(userId);
			return "User deleted successfully";
		} catch (Exception e) {
			return "Error while deleting user";
		}
	}
}
