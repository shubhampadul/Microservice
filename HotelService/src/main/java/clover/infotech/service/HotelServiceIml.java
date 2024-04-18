package clover.infotech.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clover.infotech.entity.Hotel;
import clover.infotech.exception.ResourceNotFoundException;
import clover.infotech.repo.HotelRepo;

@Service
public class HotelServiceIml implements HotelService {
	
	@Autowired
	private HotelRepo repo;

	@Override
	public Hotel saveHotelDetails(Hotel hotel) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		hotel.setHotelId(randomUserId);
		return repo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotelDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Hotel getHotelByIg(String hotelId) {
		// TODO Auto-generated method stub
		return repo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found"));
	}

}
