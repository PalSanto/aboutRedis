package com.demxntia.springdataredisdemo;

import com.demxntia.springdataredisdemo.RedisInfo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringRedisDemoApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void TestString(){
        redisTemplate.opsForValue().set("name","alex");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name=" + name);

    }
    @Test
    void TestSaveUser(){
        redisTemplate.opsForValue().set("user",new User("demxntia",21));

        Object user = (User)redisTemplate.opsForValue().get("user");
        System.out.println(user);

    }

}
