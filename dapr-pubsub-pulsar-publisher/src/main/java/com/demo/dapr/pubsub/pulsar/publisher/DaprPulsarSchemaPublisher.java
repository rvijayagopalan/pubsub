package com.demo.dapr.pubsub.pulsar.publisher;


import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;

@RestController
public class DaprPulsarSchemaPublisher {
	
	@RequestMapping("/pschema")
	public String publish() {
		try {
			DaprClient daprClient = getDaprClient();
			
			for(int i = 0; i < 10; i++) {
				daprClient.publishEvent("pulsar-pubsub",  "test-topic", "Test from Dapr Pulsar Publisher "+ LocalDateTime.now()).block();
			}
			return "Published Successfully";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Publish Failed " + e.getMessage();
		}
	}
	
	private DaprClient getDaprClient() {
	    return new DaprClientBuilder()
	            		.build();
	}	
}
