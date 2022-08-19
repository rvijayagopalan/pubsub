package com.demo.dapr.pubsub.pulsar.publisher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PulsarController {
	
		@RequestMapping("/")
		public String hello() {
			return "Hello from Dapr Pulsar Publisher!";
		}
		
		@RequestMapping("/send")
		public String publish() {
			return "Dapr Pulsar Publisher - Published!";
		}
	}