package wackyboy.top.item.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "talk")
public class Talk {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer t_id;
        private String img;
        private String content;
        private Integer u_id;
        private String upload_time;
        private Integer like_count;
        private Integer comment_count;
        private String username;
}