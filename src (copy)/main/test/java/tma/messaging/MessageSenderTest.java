package tma.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import tma.configuration.ApplicationConfiguration;
import tma.configuration.SpringMvcInitializer;
import tma.model.Order;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringMvcInitializer.class, ApplicationConfiguration.class})
@WebAppConfiguration
public class MessageSenderTest {

	String destination = "destination";
	
	@InjectMocks
	MessageSender messageSender;
	
	@Mock
	JmsTemplate jmsTemplate;
	
	@Mock
	Session session;
	
	@Mock
	Order order;
	
	@Mock
	MessageCreator messageCreator;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
//	@Test
//	public void testCreateMessage() throws JMSException{
//		messageCreator.createMessage(session);
//		Mockito.verify(session.createObjectMessage());
//	}
	
//	@Test
//	public void testSendMessage(){
//		messageSender.sendMessage(order);
//		Mockito.verify(jmsTemplate).send(destination,messageCreator);
//		}
//

}



//public void sendMessage(final Order order) {
//  	 String destination = "thisisqueuesend";
//       jmsTemplate.send(destination,new MessageCreator(){
//               @Override
//               public Message createMessage(Session session) throws JMSException{
//                   ObjectMessage objectMessage = session.createObjectMessage(order);
//                   return objectMessage;
//               }
//           });
//   }
//
//



















