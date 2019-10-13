package dev.ateam.services;

import java.util.Set;

import dev.ateam.entities.Order;

public interface OrderService {

	Order createOrder(Order order);
	boolean deleteOrder(int id);
	Order updateOrder(Order order);
	Set<Order> getAllOrders();
	Order getOrderById(int id);

	Set<Order> findByqmId(int id);
	Set<Order> findByrId(int id);
	Set<Order> findByaId(int id);

	
}