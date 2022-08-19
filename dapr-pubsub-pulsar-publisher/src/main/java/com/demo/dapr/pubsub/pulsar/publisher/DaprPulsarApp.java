package com.demo.dapr.pubsub.pulsar.publisher;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DaprPulsarApp {	

		  public static void main(String[] args) throws Exception {
		        //SpringApplication.run(DaprPulsarApp.class, args);
		    
			/*
			Options options = new Options();
		    options.addRequiredOption("p", "port", true, "The port this app will listen on");

		    DefaultParser parser = new DefaultParser();
		    CommandLine cmd = parser.parse(options, args);

		    // If port string is not valid, it will throw an exception.
		    //int port = Integer.parseInt(cmd.getOptionValue("port"));
			*/
		    int port = 9001;

		    // Start Dapr's callback endpoint by passing in the port.
		    SpringApplication app = new SpringApplication(DaprPulsarApp.class);
		    app.run(String.format("--server.port=%d", port));
		    //app.run(args);
		    
		  }
}