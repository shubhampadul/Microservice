package clover.infotech.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clover.infotech.entity.Rating;
import clover.infotech.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingService service;
	
	@PostMapping("/register")
	public ResponseEntity<Rating> saveRatingDetails(@RequestBody Rating rating){
		System.out.println("RatingController.saveRatingDetails()>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return ResponseEntity.status(HttpStatus.CREATED).body(service.registerRating(rating));
		
	}
	
	
	//Get All Rating
	@GetMapping("/allRating")
	public ResponseEntity<List<Rating>> getAllRating(){
		return ResponseEntity.ok(service.getAllRatings());
	
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		return ResponseEntity.ok(service.getRatingByUserId(userId));
		
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(service.getRatingByHotelId(hotelId));
		
		
		
	}
	
	

}
