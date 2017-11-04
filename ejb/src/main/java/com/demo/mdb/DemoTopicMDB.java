package com.demo.mdb;

import java.awt.font.TextMeasurer;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: DemoMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "DemoTopic"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic")
		}, 
		mappedName = "DemoTopic")
public class DemoTopicMDB implements MessageListener {

	Logger log=Logger.getLogger(getClass().getName());
    /**
     * Default constructor. 
     */
    public DemoTopicMDB() {

    	log.info("*************************DemoTopicMDB*****************");
    	
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	
    	log.info("Recv DemoTopic: "+message);
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
