package com.demo.dapr.pubsub.pulsar.publisher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
public class MetricPublisher {
	
	@RequestMapping("/metric")
	public String publishMetric() {
		try {
			DaprClient daprClient = getDaprClient();
			
			System.out.println("Publishing Metric");
						
			for(int i = 0; i < 10000000; i++) {
				Metric metric = new Metric();
				daprClient.publishEvent("pulsar-pubsub", "topic-metric", metric).block();
				
				System.out.println("Metric Published : "+ i);

			}
			return "Published Metric Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Publish Metric Failed " + e.getMessage();
		}
	}	
	
	private DaprClient getDaprClient() {
	    return new DaprClientBuilder()
	            		.build();
	}	
}