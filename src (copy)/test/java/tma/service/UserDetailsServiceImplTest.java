package tma.service;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import tma.configuration.ApplicationConfiguration;
import tma.configuration.SpringMvcInitializer;
import tma.model.UserModelDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringMvcInitializer.class, ApplicationConfiguration.class})
@WebAppConfiguration
public class UserDetailsServiceImplTest {
	
	@InjectMocks
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	UserModelDetails userModelDetails;
	
	@Mock
	Query query;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
//	@Test	
//	public void userModelDetailsNull(){
//		when(userModelDetails == null).the .then((Answer<String>) "abc");
//	}
	
		@Test
		public void testLoadUserByUserName(){
			//userDetailsServiceImpl.loadUserByUsername("username");
			
			when(userRepository.getUserByUsername("username")).thenReturn(userModelDetails);
			when(userModelDetails.getUsername()).thenReturn("admin");
			when(userModelDetails.getPassword()).thenReturn("123");
		    Set<String> roles = new HashSet<String>();
			 roles.add("ADMIN");
			 roles.add("USER");
			when(userModelDetails.getRoles()).thenReturn(roles);
			assertEquals(userDetailsServiceImpl.loadUserByUsername("username"),userModelDetails);
			
			//Mockito.verify(userDetailsServiceImpl.loadUserByUsername("username"),userModelDetails);
//			 List<String> user = new ArrayList<String>();
//			 user.add("admin");
//			 user.add("123");
//			 user.add("ADMIN");
//			assertEquals(userDetailsServiceImpl.loadUserByUsername("username"),user);
		}
}



