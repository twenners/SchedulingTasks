package de.wennersonline.jms;

import javax.jms.Connection;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionHandler {
	

	@Value("${activemq.broker-url}")
	private String brokerUrl;
	
	private ActiveMQConnectionFactory connectionFactory;
	
	private Connection connection;
	
	
	public Connection getConnection() throws JMSException{
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
		return connectionFactory.createConnection();
	}

	

}
