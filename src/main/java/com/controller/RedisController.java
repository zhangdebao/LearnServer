package com.controller;

import com.alibaba.fastjson.JSON;
import com.bean.ResultMsg;
import com.utils.RedisTools;
import com.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {
    @RequestMapping(value = "/operationStr", method = RequestMethod.PUT)
    public ResultMsg set (String key, String value) throws Exception {
        String result = RedisTools.addValue(key, value);
        ResultMsg resultMsg = ResultUtils.success(result, "success");
        return resultMsg;
    }

    @RequestMapping(value = "/operationStr", method = RequestMethod.GET)
    public ResultMsg get (String key) throws Exception {
        String result = RedisTools.getValue(key);
        System.out.println("result" + result);
        ResultMsg resultMsg = ResultUtils.success(JSON.parse(result), "success");
        return resultMsg;
    }
}
