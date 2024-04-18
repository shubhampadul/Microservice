package clover.infotech.service;

import java.util.List;

import clover.infotech.entity.User;

public interface UserService {
	
	//create 
	User registerUser(User user);
	
	//get All user
	List<User> fetchAllUser();
	
	//get single user of given UserID
	
	User getUserById(String userId);
	
	//

}
