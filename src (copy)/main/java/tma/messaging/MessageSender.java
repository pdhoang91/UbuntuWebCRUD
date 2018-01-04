package tma.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
 
import tma.model.Order;
 
@Component
public class MessageSender {
 
	
    @Autowired
    JmsTemplate jmsTemplate;
 
    public void sendMessage(final Order order) {
   	 String destination = "thisisqueuesend";
        jmsTemplate.send(destination,new MessageCreator(){
                @Override
                public Message createMessage(Session session) throws JMSException{
                    ObjectMessage objectMessage = session.createObjectMessage(order);
                    return objectMessage;
                }
            });
    }
    
    public void sendMessageDeleteById(final String orderId) {
   	 
        String destination = "thisisqueuedelete";
		jmsTemplate.send(destination,new MessageCreator(){
                @Override
                public Message createMessage(Session session) throws JMSException{
                    ObjectMessage objectMessage = session.createObjectMessage(orderId);
                    return objectMessage;
                }
            });
    } 
    
    public void sendMessageUpdate(final Order orderUpdate) {
      	 
        String destination = "thisisqueueupdate";
		jmsTemplate.send(destination,new MessageCreator(){
                @Override
                public Message createMessage(Session session) throws JMSException{
                    ObjectMessage objectMessage = session.createObjectMessage(orderUpdate);
                    return objectMessage;
                }
            });
    } 
    
    public void sendMessageDeleteAllOrders() {
     	 
        String destination = "thisisqueuedeleteall";
		jmsTemplate.send(destination,new MessageCreator(){
                @Override
                public Message createMessage(Session session) throws JMSException{
                    ObjectMessage objectMessage = session.createObjectMessage();
                    return objectMessage;
                }
            });
    }
}