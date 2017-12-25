package tma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import tma.model.Order;


@Service("orderRepository")
public class OrderRepositoryImpl implements OrderRepository{


	
	   final String COLLECTIONOD = "order";
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void putOrder(Order order) {
		mongoTemplate.insert(order);
	}

	@Override
	public void updateOder(Order orderUpdate) {
		mongoTemplate.save(orderUpdate);
	}
	
	@Override
	public Object delete(Query queryId) {
		return mongoTemplate.remove(queryId,Order.class);
	}
	
	public void deleteAllOrders(){
		 mongoTemplate.remove(new Query(), COLLECTIONOD);	 
	}
	
	@Override
	public Order getOrderById(Query QueryGetId) {
		return mongoTemplate.findOne(QueryGetId,Order.class);
	}
	
	public List<Order> getAllOrders(){
		return mongoTemplate.findAll(Order.class);	  
	}

}
