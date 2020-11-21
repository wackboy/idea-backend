package auth.service.service;

import auth.common.entity.UserInfo;
import auth.common.utils.JwtUtils;
import auth.service.client.UserClient;
import auth.service.config.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.item.pojo.User;

/**
 * @Author: WackyBoy
 * @Date: 2020/11/4 14:41
 */
@Service
public class AuthService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private JwtProperties properties;


    public String authentication(String username, String password) {

        try {
            // 调用微服务，执行查询
            User user = this.userClient.queryUser(username, password);
            if(user == null) {
                return null;
            }
            // 将user携带的部分信息放到token里面，可以选择添加其他信息
            String token = JwtUtils.generateToken(new UserInfo(user.getUserid(), user.getUsername(), user.getAvatar_img()), properties.getPrivateKey(), properties.getExpire());
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
