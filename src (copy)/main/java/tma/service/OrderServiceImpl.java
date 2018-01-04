package tma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import tma.messaging.MessageSender;
import tma.model.Order;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
    MessageSender messageSender;

	
	@Autowired
	OrderRepository orderRepository;
	
	
	@Override
	public void sendOrder(Order order) {
		messageSender.sendMessage(order);
	}
	
	@Override
	public void updateOrder(Order orderUpdate) {
		messageSender.sendMessageUpdate(orderUpdate);
	}
	
	@Override
	public void deleteById(String orderId) {
		messageSender.sendMessageDeleteById(orderId);
	}	
	
	public List<Order> getAllOrders(){
		return orderRepository.getAllOrders();
	}
	
	@Override
	public Order getOrderById(String orderId) {		
		Query QueryGetId = new Query(Criteria.where("_id").is(orderId));
		return orderRepository.getOrderById(QueryGetId);
	}
	
	@Override
	public void deleteAllOrders() {		
		messageSender.sendMessageDeleteAllOrders();
	}
}
