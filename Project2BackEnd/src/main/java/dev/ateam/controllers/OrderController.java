package dev.ateam.controllers;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.ateam.entities.Order;
import dev.ateam.services.OrderService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

  @Autowired
  @Qualifier("OrderServiceDATA")
  OrderService os;

  // create
  @RequestMapping(value = "/orders", method = RequestMethod.POST)
  public Order createOrder(@RequestBody Order order) {
      return os.createOrder(order);
  }

  // read
  @RequestMapping(value = "/orders", method = RequestMethod.GET)
  public Set<Order> allOrders() {
      return os.getAllOrders();
  }

  @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
  public Order getOrder(@PathVariable int id) {
      return os.getOrderById(id);
  }

  // update use the put method for updating a resource
  // put should update a resource if it exists else it will create a new associate
  @RequestMapping(value = "/orders", method = RequestMethod.PUT)
  public Order updateOrder(@RequestBody Order order) {
      return os.updateOrder(order);
  }

  // delete
  @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
  public boolean removeOrder(@PathVariable int id) {
      return os.deleteOrder(id);
  }
  
  @RequestMapping(value = "/orders/quartermaster/{id}", method = RequestMethod.GET)
  public Set<Order> findByqmId(@PathVariable int id) {
	  return os.findByqmId(id);
  }

  @RequestMapping(value = "/orders/requester/{id}", method = RequestMethod.GET)
  public Set<Order> findByrId(@PathVariable int id) {
	  return os.findByrId(id);
  }
  
  @RequestMapping(value = "/orders/assembler/{id}", method = RequestMethod.GET)
  public Set<Order> findByaId(@PathVariable int id) {
	  return os.findByaId(id);
  }
  
  
}
