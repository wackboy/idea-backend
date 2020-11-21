package wackyboy.top.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wackyboy.top.item.pojo.Favo;
import wackyboy.top.item.pojo.Talk;
import wackyboy.top.item.service.TalkService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WackyBoy
 * @Date: 2020/10/27 20:23
 */
@Controller
//@RequestMapping("/talk")
public class TalkController {

    @Autowired
    private TalkService talkService;

    /**
     * @queryAllTalkInfo：查询所有的闲聊信息
     * @return
     */
    @GetMapping("/talk")
    public ResponseEntity<List<Talk>> queryAllTalkInfo() {
        List<Talk> talkList = this.talkService.queryAllInfo();
        return ResponseEntity.ok(talkList);
    }

    /**
     * 用户点赞，依据用户的u_id和对应的t_id更新Talk表、like表的信息
     * @param t_id
     * @return
     */
    @PostMapping("/like")
    public ResponseEntity<Void> updateTalk(@RequestParam("t_id")Integer t_id, @RequestParam("u_id")Integer u_id) {

        // 查询like表中是否有对应的u_id和t_id，有则将状态置反，无则创建置True.其中u_id应该从传递过来的token中获取
        Favo favo = this.talkService.queryByTalkIdAndUserId(t_id, u_id);
        if(favo == null) {
            // 如果并没有该条记录，则添加记录
            Integer flag = this.talkService.insertInfo(t_id, u_id);
        } else {
            // 数据库中存在该记录，则删除记录
            Integer flag = this.talkService.deleteInfo(t_id, u_id);
        }
        // 使用聚合查询，更新talk表
        this.talkService.updateInfo();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/like/{userid}")
    public ResponseEntity<List<Integer>> queryLikeList(@PathVariable("userid")Integer userid) {
        // 根据userid查询对应的likeList
        List<Favo> likes = this.talkService.queryLikeIdByUserId(userid);
        List<Integer> like_tlist = new ArrayList<>();
        // 成功返回list
        for(Favo like : likes) {
            like_tlist.add(like.getT_id());
        }
        // 返回的就是该用户对应点过赞的talkid
        return ResponseEntity.ok(like_tlist);

    }

}
