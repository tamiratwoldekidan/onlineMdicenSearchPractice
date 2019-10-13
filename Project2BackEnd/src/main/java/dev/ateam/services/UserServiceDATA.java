package dev.ateam.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.ateam.entities.AppUser;
import dev.ateam.repositories.UserRepository;

@Component
@Service("UserServiceDATA")
public class UserServiceDATA implements UserService{
	
	@Autowired
	UserRepository ar;

	@Override
	public AppUser createUser(AppUser user) {
		if( getUserById(user.getId())== null)
		{
			user.setId(0);
		}
		return ar.save(user);
	}

	@Override
	public AppUser getUserById(int id) {
		try {
		AppUser user = ar.findById(id).get();
		return user;
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public Set<AppUser> allUsers() {
		Iterable<AppUser> users = ar.findAll();
		Set<AppUser> userset = new HashSet<AppUser>((Collection<? extends AppUser>) users);
		
		return userset;
	}

	@Override
	public AppUser updateUser(AppUser user) {
		ar.save(user);
		return user;
	}

	@Override
	public boolean deleteUser(AppUser user) {
		ar.delete(user);
		return true;
	}

	@Override
	public AppUser loginUser(AppUser user) {
		List<AppUser> theUsers= ar.findByUsername(user.getUsername());
		for(AppUser curUserEvaluated: theUsers) {
			if(curUserEvaluated.getPassword().equals(user.getPassword())){ 
				return curUserEvaluated;
			}
		}


		return null;
	}

  @Override
  public List<AppUser> findByUsername(String name) {
    return  ar.findByUsername(name);
  }

	
	

}
