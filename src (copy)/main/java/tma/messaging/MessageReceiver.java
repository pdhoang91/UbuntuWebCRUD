package tma.messaging;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import tma.model.Order;
import tma.service.MessageCallRepository;
import tma.service.OrderRepository;
import tma.service.OrderService;
 
@Component
public class MessageReceiver {
    static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);
 
    private static final String ORDER_RESPONSE_QUEUE = "thisisqueuesend";
    private static final String ORDER_RESPONSE_QUEUE_DELETE = "thisisqueuedelete";
    private static final String ORDER_RESPONSE_QUEUE_UPDATE = "thisisqueueupdate";
    private static final String ORDER_RESPONSE_QUEUE_DELETEALL = "thisisqueuedeleteall";
   
     
    @Autowired
    OrderService orderService;
    
    @Autowired
    OrderRepository orderRepository;
    
    @Autowired
    MessageCallRepository messageCallRepository;
     
     
    @JmsListener(destination = ORDER_RESPONSE_QUEUE)
    public void receiveMessage(final Message<Order> message) throws JMSException {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        MessageHeaders headers =  message.getHeaders();
        LOG.info("Application : headers received : {}", headers);
         
        Order order = message.getPayload();
        LOG.info("Application : response received : {}",order);
        
        messageCallRepository.sendOrder(order);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    
    @JmsListener(destination = ORDER_RESPONSE_QUEUE_DELETE)
    public void receiveMessageDeleteById(final Message<String> message) throws JMSException {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        MessageHeaders headers =  message.getHeaders();
        LOG.info("Application : headers received : {}", headers);
         
        String orderId = message.getPayload();
        LOG.info("Application : response received : {}",orderId);
        
        messageCallRepository.deleteOrderById(orderId);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    
    @JmsListener(destination = ORDER_RESPONSE_QUEUE_UPDATE)
    public void receiveMessageUpdateById(final Message<Order> message) throws JMSException {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        MessageHeaders headers =  message.getHeaders();
        LOG.info("Application : headers received : {}", headers);
         
        Order orderUpdate = message.getPayload();
        LOG.info("Application : response received : {}",orderUpdate);
        
        messageCallRepository.updateOrder(orderUpdate);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    
    @JmsListener(destination = ORDER_RESPONSE_QUEUE_DELETEALL)
    public void receiveMessageDeleteAllOrders() throws JMSException {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        messageCallRepository.deleteAllOrders();
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    
}


