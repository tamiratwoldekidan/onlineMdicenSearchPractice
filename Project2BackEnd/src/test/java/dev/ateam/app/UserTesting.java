package dev.ateam.app;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import dev.ateam.entities.AppUser;
import dev.ateam.services.UserService;

@ExtendWith(SpringExtension.class)
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@ContextConfiguration(classes = dev.ateam.app.PcppTwo.class)
class UserTesting {

	@Autowired
	@Qualifier("UserServiceDATA")
	UserService us;
	
	
	@Test
	@Commit
	@Order(1)
	void createUser() {
		AppUser user = new AppUser(0,"TestUser","Pass","crash test dummy");
		user = us.createUser(user);
	}

	@Test
	@Commit
	@Order(2)
	void findUserByName() {
		AppUser user = us.findByUsername("TestUser").get(0);
		System.out.println(user);
		Assert.notNull(user);	
	}


	@Test
	@Order(3)
	//TODO:edge cases could cause this to be an issue
	//@EnabledIf(value= {findNameWorks,"true"})
	//@EnabledIf("findNameWorks!=null)")
	@Rollback
	void updateUser() {
		AppUser user = us.findByUsername("TestUser").get(0);
		user.setPassword(user.getUsername()+Math.random()*1000);
		us.updateUser(user);
		System.out.println(user);
	}
	
	@Order(4)
	@Commit
	@Test
	void deleteUser() {
		AppUser user = us.findByUsername("TestUser").get(0);
		us.deleteUser(user);
	}

	
	
}
