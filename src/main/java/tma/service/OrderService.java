package tma.service;

import java.util.List;

import tma.model.Order;

public interface OrderService {
	
	public void sendOrder(Order order);
	
	public void updateOrder(Order orderUpdate);
	
	public void deleteById(String orderId);
	
	public void deleteAllOrders();
	
	public Order getOrderById(String orderId);
	
	public List<Order> getAllOrders();
	
}
