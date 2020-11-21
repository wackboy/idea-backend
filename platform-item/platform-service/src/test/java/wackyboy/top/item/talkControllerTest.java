package wackyboy.top.item;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wackyboy.top.item.pojo.Talk;
import wackyboy.top.item.service.TalkService;

import java.util.List;

/**
 * @Author: WackyBoy
 * @Date: 2020/10/27 20:46
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class talkControllerTest {

    @Autowired
    private TalkService talkService;

    @Test
    public void getTalkInfo() {
        List<Talk> talkList = this.talkService.queryAllInfo();
        talkList.forEach(System.out::println);
    }


}
