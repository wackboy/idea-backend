package wackyboy.top.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wackyboy.top.item.service.UserService;

/**
 * @Author: WackyBoy
 * @Date: 2020/10/27 14:51
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;






}
