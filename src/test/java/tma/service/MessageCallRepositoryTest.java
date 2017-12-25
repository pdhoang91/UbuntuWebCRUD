package tma.service;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import tma.configuration.ApplicationConfiguration;
import tma.configuration.SpringMvcInitializer;
import tma.model.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringMvcInitializer.class, ApplicationConfiguration.class})
@WebAppConfiguration
public class MessageCallRepositoryTest {
	
	@InjectMocks
	MessageCallRepository messageCallRepository;
	
	@Mock
	OrderRepository orderRepository;	
	
	@Mock
	Order order;
	
	@Mock
	Query query;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
		@Test
		public void testSendOrder() {
			messageCallRepository.sendOrder(order);
			Mockito.verify(orderRepository).putOrder(order);
		}
		
		@Test
		public void testUpdateOrder(){
			messageCallRepository.updateOrder(order);
			Mockito.verify(orderRepository).updateOder(order);
		}
		
		@Test
		public void testDeleteOrderById(){
			messageCallRepository.deleteOrderById("abcxyz");
			Mockito.verify(orderRepository).delete(Mockito.any(Query.class));
		}
		
		@Test
		public void testDeleteAllOrders(){
			messageCallRepository.deleteAllOrders();
			Mockito.verify(orderRepository).deleteAllOrders();
		}
		
}











