package tma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import tma.model.Order;

@Service("messageCallRepository")
public class MessageCallRepository {
	
	@Autowired
	OrderRepository orderRepository;
	
	public void sendOrder(Order order) {
		orderRepository.putOrder(order);
	}
	
	public void updateOrder(Order orderUpdate) {
		orderRepository.updateOder(orderUpdate);
	}
	
	public void deleteOrderById(String orderId) {
		Query QueryId = new Query(Criteria.where("_id").is(orderId));
		orderRepository.delete(QueryId);
	}
	
	public void deleteAllOrders() {
		orderRepository.deleteAllOrders();
	}
}
