package com.bookyourticket.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.bookyourticket.dto.RegistrationInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RegistrationMessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	
	private String queue="Registration";
	
	public void send(String name,String email) throws JsonProcessingException
	{
		RegistrationInfo registrationInfo = new RegistrationInfo(name, email);
		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString = mapper.writeValueAsString(registrationInfo);
		System.out.println("Message to Send to JMS "+writeValueAsString);
		jmsTemplate.convertAndSend(queue, writeValueAsString);
		System.out.println("====== Message Sent ======");
	}
}
