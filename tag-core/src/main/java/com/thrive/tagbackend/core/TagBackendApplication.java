package com.thrive.tagbackend.core;

import com.thrive.inmemory.InMemory;
import com.thrive.tagbackend.core.repository.TagRepository;
import com.thrive.tagbackend.core.util.TagUtils;
import io.nats.client.*;
import io.nats.client.api.PublishAck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

// @TODO: Look into nats.io queues

@SpringBootApplication()
public class TagBackendApplication {

	private static final int WIDTH = 300;
	private static final int HEIGHT = 100;

	private static final Logger log = LoggerFactory.getLogger(TagBackendApplication.class);

	public static String[] ARGS;

	protected static Connection natsConnection;
	protected static JetStream jetStream;

	public static void main(String[] args) {
		System.out.println("Starting Tag Backend Application.");

		ARGS = args;

		connectToNats();


		InMemory inMemory = new InMemory("localhost", 6379);

		//testCompositionConnection();



		JFrame frame = new JFrame("Tag CRUD Application Server");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH,HEIGHT);

		JLabel label = new JLabel("Running server...", SwingConstants.CENTER);
		frame.getContentPane().add(label);

		frame.setVisible(true);



		//SpringApplication.run(TagBackendApplication.class, args);
	}

	private static void connectToNats() {
		System.out.println("Connecting to NATS server...");
		try {
			natsConnection = Nats.connect("nats://localhost:4222");
			jetStream = natsConnection.jetStream();
			System.out.println("Connected to NATS server.");
		} catch (Exception e) {
			System.out.println("Failed to connect to NATS server.");
		}
	}

	@Bean
	public CommandLineRunner CreateSampleData(TagRepository repository) {
		return (args) -> {
			int maxGroup = 1;
			int maxElement = 1;
			repository.saveAll(TagUtils.getRandomTags(maxGroup, maxElement));
		};
	}

	public static void testCompositionConnection() {
		// Send a message to the compositing service

		try {
			// [begin publish_with_reply]
			Connection nc = Nats.connect("nats://localhost:4222");

			// Create a unique subject name
			String uniqueReplyTo = NUID.nextGlobal();

			// Listen for a single response
			Subscription sub = nc.subscribe(uniqueReplyTo);
			sub.unsubscribe(1);

			// Send the request
			String message = "Hello World";
			nc.publish("updates", uniqueReplyTo, message.getBytes(StandardCharsets.UTF_8));

			// Read the reply
			Message msg = sub.nextMessage(Duration.ofSeconds(1));

			// Use the response
			System.out.println(new String(msg.getData(), StandardCharsets.UTF_8));

			// Close the connection
			nc.close();
			// [end publish_with_reply]
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
