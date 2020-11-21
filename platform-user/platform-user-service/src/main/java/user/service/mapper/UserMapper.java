package user.service.mapper;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import user.item.pojo.User;

/**
 * @Author: WackyBoy
 * @Date: 2020/10/29 13:54
 */
@Repository
public interface UserMapper extends Mapper<User> {
}
