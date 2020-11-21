package wackyboy.top.item.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import wackyboy.top.item.pojo.Talk;

import java.util.List;

/**
 * @Author: WackyBoy
 * @Date: 2020/10/27 20:43
 */

public interface TalkMapper extends Mapper<Talk> {

    @Select("SELECT * FROM talk INNER JOIN user on user.userid=talk.u_id ")
    List<Talk> selectAll();
}
