package com.fsd.projectmanager.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fsd.projectmanager.entity.User;
import com.fsd.projectmanager.model.UserModel;
;

public class TestUtils {
	
    public static String serializeObjectAsJsonString(Object object) throws IOException{
    	ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(object);
    }
    
    public static User getUser() {
    	User user = new User(1, "sneha", "paulson", 123);
    	return user;
    }
    
    public static UserModel getUserModel() {
    	UserModel user = new UserModel(1, "sneha", "paulson", 123);
    	return user;
    }
    
   /* public static Project getProject() throws Exception {
    	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    	Project project = new Project(1, "project1", "john", 8, sdf.parse("06-25-2019"),
    			 sdf.parse("06-30-2019"), true, 0, 0);
		return project;
    }
    
	public static Task getTask() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		Task task = new Task(2, 1,"task2", "task1", sdf.parse("06-25-2019"),
   			 sdf.parse("06-30-2019"),
				10, true, 1, 1, "project1");
		return task;
	}*/
}
