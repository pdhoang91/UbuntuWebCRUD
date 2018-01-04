package tma.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;
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
public class OrderRepositoryImplTest {
	
	@InjectMocks
	OrderRepositoryImpl orderRepositoryImpl;
	
	@Mock
	MongoTemplate mongoTeaplate;
	
	@Mock
	Order order;
	
	@Mock
	Query query;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
		@Test
		public void testGetAllOrder(){
			orderRepositoryImpl.getAllOrders();
			Mockito.verify(mongoTeaplate).findAll(Order.class);
			}
	
		@Test
		public void testGetOrderById(){
			orderRepositoryImpl.getOrderById(query);
			Mockito.verify(mongoTeaplate).findOne(query, Order.class);
		}
	
		@Test
		public void testPutOrder() {
			orderRepositoryImpl.putOrder(order);
			Mockito.verify(mongoTeaplate).insert(order);
		}
		
		
		@Test
		public void testUpdateOrder(){
			orderRepositoryImpl.updateOder(order);
			Mockito.verify(mongoTeaplate).save(order);
		}
		
		@Test
		public void testDeleteOrderById(){
			orderRepositoryImpl.delete(query);
			Mockito.verify(mongoTeaplate).remove(query,Order.class);
		}
		
		@Test
		public void testDeleteAllOrders(){
			orderRepositoryImpl.deleteAllOrders();
			Mockito.verify(mongoTeaplate).remove(new Query(),"order");
		}
}











