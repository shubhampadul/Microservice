package clover.infotech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clover.infotech.entity.Rating;
import clover.infotech.repo.RatingRepo;

@Service
public class RatingServiceIml implements RatingService {
	
	@Autowired
	private RatingRepo repo;

	@Override
	public Rating registerRating(Rating rating) {
		System.out.println("RatingServiceIml.registerRating()<<<<<<<<<<<<<<<<<<<<<<<");
		return repo.save(rating);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return repo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return repo.findByHotelId(hotelId);
	}

}
