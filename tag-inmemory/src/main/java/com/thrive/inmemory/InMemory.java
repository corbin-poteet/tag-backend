package com.thrive.inmemory;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;

public class InMemory {

    private static final Logger LOGGER = LoggerFactory.getLogger(InMemory.class);

    private final RedisClient redisClient;
    private final StatefulRedisConnection<String, String> connection;

    public static void printHello() {
        System.out.println("Hello, world!");
    }

    public InMemory(String host, int port) {
        redisClient = RedisClient.create("redis://" + host + ":" + port);
        connection = redisClient.connect();
    }

    public void set(String key, String value) {
        RedisAsyncCommands<String, String> asyncCommands = connection.async();
        asyncCommands.set(key, value);
    }

    public String get(String key) {
        RedisAsyncCommands<String, String> asyncCommands = connection.async();
        try {
            return asyncCommands.get(key).get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error("Error getting value for key {}", key, e);
            return null;
        }
    }
}