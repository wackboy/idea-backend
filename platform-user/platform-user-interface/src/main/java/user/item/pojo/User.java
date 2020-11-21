package user.item.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 给需要条件约束的参数加注解
 * @Author: WackyBoy
 * @Date: 2020/10/29 13:17
 */
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;

    private String username;
    @JsonIgnore
    private String password;
    private String avatar_img;
    private Date created;
    @JsonIgnore
    private String salt;        // 密码的盐值

}
