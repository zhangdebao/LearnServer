package com.controller;

import com.utils.RedisClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private RedisClients redisClients;
    @RequestMapping(value = "/set")
    public String set (String key, String value) throws Exception {
        redisClients.set(key, value, 10);
        return "success";
    }
}
