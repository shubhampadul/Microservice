package clover.infotech.external.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import clover.infotech.entity.Hotel;

@FeignClient(name = "Hotel-Service")
public interface HotelService {
	
	@GetMapping("/hotel/{hotelId}")
	Hotel getHotelById(@PathVariable("hotelId") String hotelId);

}
