package com.thrive.tagbackend.composition;

import io.nats.client.Connection;
import io.nats.client.JetStream;
import io.nats.client.Nats;

public class CompositingService {
    protected static Connection natsConnection;
    protected static JetStream jetStream;

    public static void main(String[] args) {
        System.out.println("Starting Tag Composition Service.");
        connectToNats();
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
}
