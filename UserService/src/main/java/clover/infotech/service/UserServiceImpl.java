package clover.infotech.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import clover.infotech.entity.Hotel;
import clover.infotech.entity.Rating;
import clover.infotech.entity.User;
import clover.infotech.excetion.ResourceNotFoundException;
import clover.infotech.external.server.HotelService;
import clover.infotech.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private org.slf4j.Logger logger=LoggerFactory.getLogger(UserService.class);

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
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on Server "+userId));
		//consume the rating of the above user from RATING SERVICE
	   // String apiUrl="http://localhost:7878/rating/users/18655a80-1cdd-42bd-a2db-3a9175d4f873";
		//Manual Add
		//ArrayList arrObj = restTemplate.getForObject("http://localhost:7878/rating/users/18655a80-1cdd-42bd-a2db-3a9175d4f873",ArrayList.class);
		System.out.println("UserServiceImpl.getUserById()>>>>>>>>>>>>>>http://localhost:7878/rating/users/");
		//Dinamicall
		Rating[] ratingOfUser=restTemplate.getForObject("http://Rating-Service/rating/users/"+user.getUserId(), Rating[].class);
		System.out.println("REst Api Call>>>>>>>>>>>>>>:"+ratingOfUser);
		
		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
		
		  List<Rating> ratingList = ratings.stream().map(rating -> {
			  //api call to hotel service to get the hotel
			  //http://localhost:8181/hotel/e9a5765f-d84b-47b7-826f-d5ebd2fb62ea
			//  ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://Hotel-Service/hotel/"+rating.getHotelId(), Hotel.class);
			 Hotel hotel = hotelService.getHotelById(rating.getHotelId());
			 // Hotel hotel = forEntity.getBody();
			 // System.out.println("response status code: <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+forEntity.getStatusCode());
		  
		  //set the hotel to rating 
			  rating.setHotel(hotel);
			  
			  //Return the rating 
			  return rating;
		  
		  }).collect(Collectors.toList());
		  
		  user.setRatings(ratingList);
		
		 
		
		
		return user;
  	}
}
