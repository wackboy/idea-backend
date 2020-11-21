package wackyboy.top.item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wackyboy.top.item.mapper.UserMapper;

/**
 * @Author: WackyBoy
 * @Date: 2020/10/27 15:11
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;



}
