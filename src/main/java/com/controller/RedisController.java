package com.controller;

import com.alibaba.fastjson.JSON;
import com.bean.ResultMsg;
import com.utils.RedisClients;
import com.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private RedisClients redisClients;
    @RequestMapping(value = "/operationStr", method = RequestMethod.PUT)
    public String set (String key, String value) throws Exception {
        redisClients.set(key, value, 10);
        return "success";
    }

    @RequestMapping(value = "/operationStr", method = RequestMethod.GET)
    public ResultMsg get (String key) throws Exception {
        String result = redisClients.get(key);
        ResultMsg resultMsg = ResultUtils.success(JSON.parse(result), "success");
        return resultMsg;
    }
}
