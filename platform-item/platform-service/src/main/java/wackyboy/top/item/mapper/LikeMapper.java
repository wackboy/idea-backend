package wackyboy.top.item.mapper;

import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
import wackyboy.top.item.pojo.Favo;

/**
 * @Author: WackyBoy
 * @Date: 2020/11/9 20:42
 */
public interface LikeMapper extends Mapper<Favo> {

    @Update("update talk as tt set tt.like_count = (select count(*) from `favo` as li where tt.t_id = li.t_id)")
    void updateByt_id();
}
