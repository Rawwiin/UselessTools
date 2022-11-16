package com.example.uselesstools.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.uselesstools.model.entry.User;
import org.springframework.stereotype.Repository;

/**
 * @author Rawwiin
 */
@Repository   //告诉容器你是持久层的 @Repository是spring提供的注释，能够将该类注册成Bean
public interface UserMapper extends BaseMapper<User> {
}
