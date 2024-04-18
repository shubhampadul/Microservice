package clover.infotech.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clover.infotech.entity.User;
import clover.infotech.excetion.ResourceNotFoundException;
import clover.infotech.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User registerUser(User user) {
		// generate unique userId
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId	);
		return userRepo.save(user);
	}

	@Override
	public List<User> fetchAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on Server "+userId));
	}

}
