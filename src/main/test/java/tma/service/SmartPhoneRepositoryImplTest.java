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
import tma.model.SmartPhone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringMvcInitializer.class, ApplicationConfiguration.class})
@WebAppConfiguration
public class SmartPhoneRepositoryImplTest {
	
	@InjectMocks
	SmartPhoneRepositoryImpl smartPhoneRepositoryImpl;
	
	@Mock
	MongoTemplate mongoTeaplate;
	
	@Mock
	SmartPhone smartPhone;
	
	@Mock
	Query query;
	
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
		@Test
		public void testGetAllSmartPhone(){
			smartPhoneRepositoryImpl.getAllSmartPhones();
			Mockito.verify(mongoTeaplate).findAll(SmartPhone.class);
			}
	
		@Test
		public void testGetSmaerPhoneById(){
			smartPhoneRepositoryImpl.getSmartPhoneById(query);
			Mockito.verify(mongoTeaplate).findOne(query, SmartPhone.class);
		}
	
		@Test
		public void testPutSmartPhone() {
			smartPhoneRepositoryImpl.putSmartPhone(smartPhone);
			Mockito.verify(mongoTeaplate).insert(smartPhone);
		}
		
		@Test
		public void testUpdateSmartPhone(){
			smartPhoneRepositoryImpl.updateSmartPhone(smartPhone);
			Mockito.verify(mongoTeaplate).save(smartPhone);
		}
		
		@Test
		public void testDeleteSmartPhoneById(){
			smartPhoneRepositoryImpl.deleteSmartPhoneById(query);
			Mockito.verify(mongoTeaplate).remove(query,SmartPhone.class);
		}
		
		@Test
		public void testDeleteAllSmartPhone(){
			smartPhoneRepositoryImpl.deleteAllSmartPhones();
			Mockito.verify(mongoTeaplate).remove(new Query(),"smartphone");
		}
}











