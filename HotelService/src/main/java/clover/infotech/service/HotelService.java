package clover.infotech.service;

import java.util.List;

import clover.infotech.entity.Hotel;

public interface HotelService {
	
	Hotel saveHotelDetails(Hotel hotel);
	
	List<Hotel> getAllHotelDetails();
	
	Hotel getHotelByIg(String hotelId);

}
