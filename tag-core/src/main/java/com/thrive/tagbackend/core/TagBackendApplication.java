package com.thrive.tagbackend.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

import static com.thrive.inmemory.Main.initializeRedisConnection;

@SpringBootApplication()
public class TagBackendApplication {

	private static final int WIDTH = 300;
	private static final int HEIGHT = 100;
	public static void main(String[] args) {

		JFrame frame = new JFrame("Tag CRUD Application Server");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH,HEIGHT);

		JLabel label = new JLabel("Running server...", SwingConstants.CENTER);
		frame.getContentPane().add(label);

		frame.setVisible(true);

		initializeRedisConnection();

		SpringApplication.run(TagBackendApplication.class, args);
	}
}
