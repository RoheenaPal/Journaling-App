package com.project.journalApp.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RedisService {
    @Autowired
    RedisTemplate redisTemplate;

    public <T> T get(String key, Class<T> entityClass) {
        Object o = redisTemplate.opsForValue().get(key);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(o.toString(), entityClass);
        } catch (Exception e) {
            log.error("Exception", e);
            return null;
        }
    }

    public void set(String key, Object o, Long expiryTime) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonValue = objectMapper.writeValueAsString(o);
            redisTemplate.opsForValue().set(key, jsonValue, expiryTime, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("Exception ", e);
        }
    }
}
