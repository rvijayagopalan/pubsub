package com.demo.dapr.pubsub.pulsar.subscriber;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@Getter @Setter
public class User {
    private String name;
    private Integer age;
    
    public User(String name, Integer age) {
    	this.name = name;
    	this.age = age;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public Integer getAge() {
    	return this.age;
    }

}