package clover.infotech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import clover.infotech.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String> {

}
