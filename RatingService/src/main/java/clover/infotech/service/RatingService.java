package clover.infotech.service;

import java.util.List;

import clover.infotech.entity.Rating;

public interface RatingService {
	
	//create
	Rating registerRating(Rating rating);
	
	//get All rating 
	List<Rating> getAllRatings();
	
	//get all by user Id
	List<Rating> getRatingByUserId(String userId);
	
	//get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);
	
	

}
