package com.example.demoactiveMQ.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;

@Component
public class MyJmsConsumer {
//	 	@Autowired JmsTemplate jmsTemplate;
	 	

		
	@JmsListener(destination = "IncomingMessage")
	@SendTo("outboundQueue")
		public String recieveMessage(Message message) throws JMSException {

			TextMessage textMessage = (TextMessage)message;
			String messageOut = textMessage.getText() + " Received....";

			System.out.println(messageOut);

			return messageOut;

		}
}
