package com.demo.dapr.pubsub.pulsar.subscriber;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PulsarController {
	
		@RequestMapping("/")
		public String hello() {
			return "Hello from Dapr Pulsar Subscriber!";
		}
		
		@RequestMapping("/read")
		public String publish() {
			return "Dapr Pulsar Subscriber - Consumed!";
		}
	}