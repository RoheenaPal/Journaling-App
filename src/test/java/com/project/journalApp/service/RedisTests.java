package com.project.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void sendMailTests() {
        redisTemplate.opsForValue().set("email", "abc@gmail.com");
        Object email = redisTemplate.opsForValue().get("email");
    }
}
