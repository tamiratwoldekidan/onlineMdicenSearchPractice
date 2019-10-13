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

import dev.ateam.entities.Build;
import dev.ateam.services.BuildService;


@ExtendWith(SpringExtension.class)
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@ContextConfiguration(classes = dev.ateam.app.PcppTwo.class)
class BuildTesting {

	@Autowired
	@Qualifier("BuildServiceDATA")
	BuildService bs;
	
	

	@Test
	void createBuild() {
	    Build testBuild = new Build(0,"monkeys,lotsOfMonkeys"+Math.random());
		testBuild = bs.createBuild(testBuild);
		testBuild.setPartList(testBuild.getPartList()+Math.random());
		bs.updateBuild(testBuild);
		bs.deleteBuild(testBuild);
	}
	



}
