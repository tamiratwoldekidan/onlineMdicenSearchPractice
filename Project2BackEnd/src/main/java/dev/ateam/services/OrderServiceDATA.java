package dev.ateam.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.ateam.entities.Order;
import dev.ateam.repositories.OrderRepository;

@Component
@Service("OrderServiceDATA")
public class OrderServiceDATA implements OrderService{

	@Autowired
	OrderRepository or;
	
	@Override
	public Order createOrder(Order order) {
	    
		order = or.save(order);
		return order;
	}

	
	
	@Override
	public boolean deleteOrder(int id) {
		or.deleteById(id);
		return true;
	}

//	@Override
//	public Order updateOrder(Order order) {
//		or.save(order);
//		return order;
//	}

	@Override
    public Order updateOrder(Order order) {
        return or.save(order);
    }
	
	@Override
	public Set<Order> getAllOrders() {
		Iterable<Order> order = or.findAll();
		Set<Order> orderSet = new HashSet<Order>((Collection<? extends Order>) order);
		
		return orderSet;
	}

	@Override
	public Order getOrderById(int id) {
		Order order = or.findById(id).get();
		return order;
	}



	@Override
	public Set<Order> findByqmId(int id) {
		return or.findByqmId(id);
	}



	@Override
	public Set<Order> findByrId(int id) {
		return or.findByrId(id);
	}



	@Override
	public Set<Order> findByaId(int id) {
		return or.findByaId(id);
	}




	
	
}