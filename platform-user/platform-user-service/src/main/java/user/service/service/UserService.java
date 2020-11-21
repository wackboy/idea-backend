package user.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.item.pojo.User;
import user.item.utils.CodecUtils;
import user.service.mapper.UserMapper;

import java.util.Date;

/**
 * @Author: WackyBoy
 * @Date: 2020/10/29 13:54
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Boolean register(User user) {
        try {
            // 1. 生成盐
            String salt = CodecUtils.generateSalt();
            // 2. 给密码加盐
            String md5Hex = CodecUtils.md5Hex(user.getPassword(), salt);
            // 3. 将用户和加盐后的密码以及盐值存储到数据库中
            user.setSalt(salt);
            user.setPassword(md5Hex);
            user.setCreated(new Date());
            // 这里为什么要判断为1?????????, 源码中有没有体现，这样判别应该就可以省去查询源数据库中是否存在相同用户的情况
            return this.userMapper.insertSelective(user) == 1;
        } catch (Exception e) {
            System.out.println("注册用户异常！");
            return false;
        }
    }

//    public boolean login(String username, String password) {
//        return true;
//    }

    public User queryUser(String username, String password) {

        // 查询
        User record = new User();
        record.setUsername(username);
        User user = this.userMapper.selectOne(record);
        // 校验用户名
        if(user == null) {
            return null;
        }
        // 校验密码
        if(!user.getPassword().equals(CodecUtils.md5Hex(password, user.getSalt()))) {
            return null;
        }
        // 返回用户
        return user;
    }
}
