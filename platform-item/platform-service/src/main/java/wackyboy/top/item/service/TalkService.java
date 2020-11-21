package wackyboy.top.item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wackyboy.top.item.mapper.LikeMapper;
import wackyboy.top.item.mapper.TalkMapper;
import wackyboy.top.item.pojo.Favo;
import wackyboy.top.item.pojo.Talk;

import java.util.List;

/**
 * @Author: WackyBoy
 * @Date: 2020/10/27 20:41
 */
@Service
public class TalkService {

    @Autowired
    private TalkMapper talkMapper;

    @Autowired
    private LikeMapper likeMapper;

    public List<Talk> queryAllInfo() {
        return this.talkMapper.selectAll();
    }

/*
    public UserInfo queryUserInfo() {

    }*/

    public List<Favo> queryLikeIdByUserId(Integer u_id) {
        Favo li = new Favo();
        li.setU_id(u_id);
        return this.likeMapper.select(li);
    }

    public Favo queryByTalkIdAndUserId(Integer t_id, Integer u_id) {

        Favo li = new Favo();
        li.setT_id(t_id);
        li.setU_id(u_id);
        return this.likeMapper.selectOne(li);

    }

    /**
     * 向Favorite表中添加记录
     * @param t_id
     * @param u_id
     * @return
     */
    public Integer insertInfo(Integer t_id, Integer u_id) {
        Favo li = new Favo();
        li.setT_id(t_id);
        li.setU_id(u_id);
        return this.likeMapper.insert(li);
    }

    /**
     * 删除Favorite表中指定的记录
     * @param t_id
     * @param u_id
     * @return
     */
    public Integer deleteInfo(Integer t_id, Integer u_id) {
        Favo li = new Favo();
        li.setT_id(t_id);
        li.setU_id(u_id);
        return this.likeMapper.delete(li);
    }

    public void updateInfo() {
        this.likeMapper.updateByt_id();
    }
}
