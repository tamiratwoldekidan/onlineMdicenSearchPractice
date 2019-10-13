package dev.ateam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.ateam.entities.AppUser;

@Repository
public interface UserRepository extends CrudRepository<AppUser,Integer> {

	List<AppUser> findByUsername(String username);
	AppUser findByUsernameAndPassword(String username, String password);

	
}
