package com.demo.dapr.pubsub.pulsar.subscriber;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.dapr.Topic;
import io.dapr.client.domain.CloudEvent;
import reactor.core.publisher.Mono;

@RestController
public class DaprPulsarSubscriber {

	private ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Topic(name = "topic-user", pubsubName = "pulsar-pubsub")
	@PostMapping(path = "/subscribe", consumes = MediaType.ALL_VALUE)
	public Mono<ResponseEntity> subscribe(@RequestBody(required = false) CloudEvent<String> event) {

		return Mono.fromSupplier(() -> {
			try {
				System.out.println("Subscriber received: " + event.getData());
				OBJECT_MAPPER.writeValueAsString(event);
				return ResponseEntity.ok("Successfully Received");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
	}
}