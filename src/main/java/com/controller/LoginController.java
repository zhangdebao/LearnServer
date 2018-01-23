package com.controller;

import com.bean.ResultMsg;
import com.bean.UserBean;
import com.utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class LoginController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public ResultMsg login(@RequestParam(value="username", defaultValue="admin") String username, @RequestParam(value = "password", defaultValue = "admin") String password) {
        UserBean userBean = new UserBean(String.format(template, username), String.format(template, password), counter.incrementAndGet());
        ResultMsg responseMsg = ResultUtils.success(userBean, "success");
        return responseMsg;
    }
}
