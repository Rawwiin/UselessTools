package com.example.uselesstools.controller;

import com.example.uselesstools.model.request.Result;
import com.example.uselesstools.model.request.ResultCode;
import com.example.uselesstools.model.entry.User;
import com.example.uselesstools.mapper.UserMapper;
import com.example.uselesstools.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rawwiin
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        System.out.println(user.toString());
        String token = userService.login(user);
        return ResultCode.SUCCESS.createResult().setData(token);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return  ResultCode.ERROR_PARAM.createResult();
        }
//        userMapper.insert(user);
        return ResultCode.SUCCESS.createResult();
    }
}
