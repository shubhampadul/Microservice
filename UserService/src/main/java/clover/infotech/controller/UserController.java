package clover.infotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clover.infotech.entity.User;
import clover.infotech.service.UserService;

@RestController
@RequestMapping( "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/registerUser")
	public ResponseEntity<User> registerUser(@RequestBody  User user){
		
		User registerUser = userService.registerUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(registerUser);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		System.out.println("UserController.getSingleUser()>>>>>>>>>>>>>>>>>>>>>>>>c28c2c11-10fc-4176-8bb2-c67a0f86e968");
		User userById = userService.getUserById(userId);
		return ResponseEntity.ok(userById);
		
		
	}
	
	@GetMapping("AllUser")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> fetchAllUser = userService.fetchAllUser();
		
		return ResponseEntity.ok(fetchAllUser);
		
	}
	
	

}
