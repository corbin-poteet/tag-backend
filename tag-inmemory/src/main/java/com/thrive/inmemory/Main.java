package com.thrive.inmemory;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void printHello() {
        System.out.println("Hello, world!");
    }

    public static boolean initializeRedisConnection() {
        try (RedisClient redisClient = RedisClient.create("redis://localhost:6379")) {
            try (StatefulRedisConnection<String, String> connection = redisClient.connect()) {
                RedisAsyncCommands<String, String> asyncCommands = connection.async();

                // Asynchronously store & retrieve a simple string
                asyncCommands.set("foo", "bar").get();
                System.out.println(asyncCommands.get("foo").get()); // prints bar

                // Asynchronously store key-value pairs in a hash directly
                Map<String, String> hash = new HashMap<>();
                hash.put("name", "John");
                hash.put("surname", "Smith");
                hash.put("company", "Redis");
                hash.put("age", "29");
                asyncCommands.hset("user-session:123", hash).get();

                System.out.println(asyncCommands.hgetall("user-session:123").get());
                // Prints: {name=John, surname=Smith, company=Redis, age=29}

                return true;
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                redisClient.shutdown();
            }
        } catch (Exception e) {
            System.out.println("Failed to connect to Redis");
        }

        return false;
    }
    public static void main(String[] args) {
        initializeRedisConnection();
    }
}
