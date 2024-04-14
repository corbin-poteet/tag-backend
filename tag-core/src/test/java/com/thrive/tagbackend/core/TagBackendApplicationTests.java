package com.thrive.tagbackend.core;

import io.nats.client.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

@SpringBootTest
@EnableCaching
class TagBackendApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testCompositionConnection() {
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
            nc.publish("time", uniqueReplyTo, null);

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
