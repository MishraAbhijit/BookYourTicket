package com.bookyourticket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookyourticket.messaging.RegistrationMessageSender;
import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootTest
class BookYourTicketApplicationTests {

	@Autowired
	RegistrationMessageSender registrationMessageSender;
	
	@Test
	void contextLoads() {
		try {
			registrationMessageSender.send("Abhijit", "sinua72@gmail.com");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
