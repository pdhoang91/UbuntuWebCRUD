package tma.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import tma.model.Order;

public interface OrderRepository {
	

	public void putOrder(Order order);
	
	public Order getOrderById(Query queryGetId);
	
	public void updateOder(Order orderUpdate);
	
	public Object delete(Query queryId);
	
	public void deleteAllOrders();
	
	public List<Order> getAllOrders();
	
}
