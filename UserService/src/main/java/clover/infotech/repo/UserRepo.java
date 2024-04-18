package clover.infotech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import clover.infotech.entity.User;

public interface UserRepo extends JpaRepository<User, String>{

}
