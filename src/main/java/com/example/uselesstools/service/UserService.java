package com.example.uselesstools.service;

import com.example.uselesstools.model.entry.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    /**
     * 登录
     * @param user
     * @return
     */
    String login(User user);
}
