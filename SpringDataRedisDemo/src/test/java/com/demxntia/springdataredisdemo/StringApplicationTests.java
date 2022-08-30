package com.demxntia.springdataredisdemo;

import com.demxntia.springdataredisdemo.RedisInfo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

@SpringBootTest
public class StringApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void TestString(){
        stringRedisTemplate.opsForValue().set("name","alex");
        Object name = stringRedisTemplate.opsForValue().get("name");
        System.out.println("name=" + name);

    }
    private static final ObjectMapper mapper = new ObjectMapper();//序列化&反序列化操作

    @Test
    void TestSaveUser() throws JsonProcessingException {
        //创建对象
        User user = new User("demxntia",21);
        //手动序列化
        String s = mapper.writeValueAsString(user);

        //写入数据
        stringRedisTemplate.opsForValue().set("user",s);
        //获取数据
        Object object = stringRedisTemplate.opsForValue().get("user");

        //手动反序列化
        User userO = mapper.readValue(s,User.class);
        System.out.println("userO=" + s);
    }
    @Test
    void  TestHash(){
        stringRedisTemplate.opsForHash().put("user1","name","venus");
        stringRedisTemplate.opsForHash().put("user1","age","21");

        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user1");
        System.out.println("entries=" + entries);
    }
}
