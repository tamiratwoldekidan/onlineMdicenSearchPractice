package dev.ateam.app;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import dev.ateam.services.OrderService;


@ExtendWith(SpringExtension.class)
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@ContextConfiguration(classes = dev.ateam.app.PcppTwo.class)
class OrderTesting {

	@Autowired
	@Qualifier("OrderServiceDATA")
	OrderService os;
	
	

	@Test
	@Order(1)
	@Rollback
	//@Commit
	void orderCreateUpdateDelete() {
	  //Order(int orderId, int qmId, int rId, int aId, Build build, String status, String requestDetails)
	    dev.ateam.entities.Order testOrder = new dev.ateam.entities.Order(0,0,0,0,"duck","100% duck.","it is a duck.");
		testOrder = os.createOrder(testOrder);
		testOrder.setStatus(testOrder.getStatus()+Math.random());
		os.updateOrder(testOrder);
		os.deleteOrder(testOrder.getOrderId());
	}


}
