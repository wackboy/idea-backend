package user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import user.item.pojo.User;
import user.service.service.UserService;

import javax.validation.Valid;

/**
 * 请求到该控制器的prefix='/api/user/'
 * 主要的功能：
 *      用户的注册
 *      校验用户名和密码是否规范
 *      给密码加盐
 *      测试
 * @Author: WackyBoy
 * @Date: 2020/10/29 13:53
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录的校验，校验用户名和密码，同时如果登录成功则要将用户的一些信息写入token, 同时做JWT鉴权, 这在auth权限模块设置
     * @param username
     * @param password
     * @return
     */
//    @GetMapping("login")
//    public ResponseEntity<User> login(@RequestParam("username")String username, @RequestParam("password")String password) {
//        this.userService.login(username, password);
//
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }

    @GetMapping("query")
    public ResponseEntity<User> queryUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        User user = this.userService.queryUser(username, password);
        if(user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(user);

    }




    /**
     * 注意这里获取到的User缺失了信息salt和created，用户名和密码判断成功之后我们要生成盐和生成时间，一起写入到数据库中
     * 这里的注册没带手机验证码验证
     * @Valid 校验用户输入的合法性
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid User user) {
//        System.out.println(user.toString());
        Boolean isRegister = this.userService.register(user);
        if(isRegister == null || !isRegister) {
            // BAD_REQUEST: 400
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        // CREATED: 201
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}


















