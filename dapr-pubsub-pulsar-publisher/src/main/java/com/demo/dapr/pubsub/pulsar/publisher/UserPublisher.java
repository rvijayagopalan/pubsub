package com.demo.dapr.pubsub.pulsar.publisher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
public class UserPublisher {
	
	@RequestMapping("/user")
	public String publishUser() {
		try {
			DaprClient daprClient = getDaprClient();
			
			System.out.println("Publishing User");
						
			for(int i = 0; i < 10; i++) {
				User user = new User("Test User" + i, i);								
				daprClient.publishEvent("pulsar-pubsub", "topic-user", user).block();
				
				System.out.println("User Published : "+ i);

			}
			return "Published User Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Publish Failed " + e.getMessage();
		}
	}
	
	@RequestMapping("/order")
	public String publishOrder() {
		String TOPIC_NAME = "orders";
		String PUBSUB_NAME = "orderpubsub";
		DaprClient client = new DaprClientBuilder().build();
		/*
		for (int i = 0; i <= 10; i++) {
			int orderId = i;
			//Order order = new Order(orderId);

			// Publish an event/message using Dapr PubSub
			client.publishEvent(
					PUBSUB_NAME,
					TOPIC_NAME,
					order).block();
			System.out.println("Published data: " + order.getOrderId());
			TimeUnit.MILLISECONDS.sleep(5000);
		}
		*/
		
		return "Published User Successfully";

	}

	
	private DaprClient getDaprClient() {
	    return new DaprClientBuilder()
	            		.build();
	}
	
}

@AllArgsConstructor
@Getter
class Order {
	private int orderId;
}

