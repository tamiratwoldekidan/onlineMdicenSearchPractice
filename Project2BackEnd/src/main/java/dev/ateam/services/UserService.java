package dev.ateam.services;

import java.util.List;
import java.util.Set;

import dev.ateam.entities.AppUser;

public interface UserService {

	
	
	AppUser createUser(AppUser user);
	
	AppUser getUserById(int id);
	
	Set<AppUser> allUsers();
	
	AppUser updateUser(AppUser user);
	
	boolean deleteUser(AppUser user);
	
	AppUser loginUser(AppUser user);
	
	List<AppUser> findByUsername(String name);
	
}
