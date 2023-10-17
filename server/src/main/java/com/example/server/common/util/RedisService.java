package com.example.server.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	
	@Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void saveData(String key, Object data) {
        redisTemplate.opsForValue().set(key, data);
    }

    public Object getData(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
