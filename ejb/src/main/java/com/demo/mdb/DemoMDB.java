package com.demo.mdb;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Message-Driven Bean implementation class for: DemoMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "DemoTopic"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic")
		}, 
		mappedName = "DemoTopic")
public class DemoMDB implements MessageListener {

	Logger log=Logger.getLogger(getClass().getName());
    /**
     * Default constructor. 
     */
    public DemoMDB() {

    	log.info("**********************************MDB*****************");
    	
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	
    	log.info("Recv : "+message);;
        
    }

}
