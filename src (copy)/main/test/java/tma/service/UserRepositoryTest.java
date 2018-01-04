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
import tma.model.UserModelDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringMvcInitializer.class, ApplicationConfiguration.class})
@WebAppConfiguration
public class UserRepositoryTest {
	
	@InjectMocks
	UserRepository userRepository;
	
	@Mock
	MongoTemplate mongoTeaplate;
	
	@Mock
	UserModelDetails userModelDetails;
	
	@Mock
	Query query;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
}
		@Test
		public void testGetUserByUserName(){
			userRepository.getUserByUsername("username");
			Mockito.verify(mongoTeaplate).findOne(Mockito.any(Query.class), UserModelDetails.class);
		}
}







