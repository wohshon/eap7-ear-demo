package com.demo.mdb;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: DemoQueueMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "DemoQueue"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "DemoQueue")
public class DemoQueueMDB implements MessageListener {
	Logger log=Logger.getLogger(getClass().getName());
    /**
     * Default constructor. 
     */
    public DemoQueueMDB() {
    	log.info("**************************DemoQueueMDB*****************");
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	log.info("Recv DemoQueue : "+message);
    	if (message instanceof TextMessage) {
    		try {
				log.info(((TextMessage) message).getText());
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}        
    }

}
