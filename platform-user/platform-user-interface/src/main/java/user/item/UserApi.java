package user.item;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import user.item.pojo.User;

/**
 * @Author: WackyBoy
 * @Date: 2020/11/4 15:15
 */
@RequestMapping("user")
public interface UserApi {

    @GetMapping("query")
    User queryUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    );
}
