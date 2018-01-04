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
import tma.model.SmartPhone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringMvcInitializer.class, ApplicationConfiguration.class})
@WebAppConfiguration
public class SmartPhoneServiceImplTest {
	
	@InjectMocks
	SmartPhoneServiceImpl smartPhoneServiceImpl;
	
	@Mock
	SmartPhoneRepository smartPhoneRepository;	
	
	@Mock
	SmartPhone smartPhone;
	
	@Mock
	Query query;
	
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
		@Test
		public void testSendSmartPhone() {
			smartPhoneServiceImpl.sendSmartPhone(smartPhone);
			Mockito.verify(smartPhoneRepository).putSmartPhone(smartPhone);
		}

		@Test
		public void testUpdateSmartPhone(){
			smartPhoneServiceImpl.updateSmartPhone(smartPhone);
			Mockito.verify(smartPhoneRepository).updateSmartPhone(smartPhone);
		}
		
		@Test
		public void testDeleteById(){
			smartPhoneServiceImpl.deleteById("abc123");
			Mockito.verify(smartPhoneRepository).deleteSmartPhoneById(Mockito.any(Query.class));
		}
		
		@Test
		public void testGetAllSmartPhone(){
			smartPhoneServiceImpl.getAllSmartPhone();
			Mockito.verify(smartPhoneRepository).getAllSmartPhones();
		}
		
		@Test
		public void testGetSmartPhoneById(){
			smartPhoneServiceImpl.getSmartPhoneById("123abc");
			Mockito.verify(smartPhoneRepository).getSmartPhoneById(Mockito.any(Query.class));
		}
		
		@Test
		public void testDeleteAllSmartPhone() {
			smartPhoneServiceImpl.deleteAllSmartPhones();
			Mockito.verify(smartPhoneRepository).deleteAllSmartPhones();
		}
		

}











