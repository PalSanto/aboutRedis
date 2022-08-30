package com.demxntia.springredissentineldemo.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private StringRedisTemplate redisTemplate;

    //get方法
    @GetMapping("/get/{key}")
    public String Test(@PathVariable String key){
        return redisTemplate.opsForValue().get(key);
    }
    //set方法
    @GetMapping("/set/{key}/{value}")
    public String Test(@PathVariable String key,@PathVariable String value){
        redisTemplate.opsForValue().set(key, value);
        return "success";
    }
}
