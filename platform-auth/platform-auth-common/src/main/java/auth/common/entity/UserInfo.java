package auth.common.entity;

/**
 * 载荷对象
 */
public class UserInfo {

    private Integer userid;

    private String username;

    private String avatar_img;

    public UserInfo() {
    }

    public UserInfo(Integer userid, String username, String avatar_img) {
        this.userid = userid;
        this.username = username;
        this.avatar_img = avatar_img;
    }

    public Integer getuserid() {
        return this.userid;
    }

    public void setuserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar_img() {
        return avatar_img;
    }

    public void setAvatar_img(String avatar_img) {
        this.avatar_img = avatar_img;
    }

}