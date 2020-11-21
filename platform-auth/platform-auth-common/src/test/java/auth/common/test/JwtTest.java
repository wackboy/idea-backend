package auth.common.test;

import auth.common.entity.UserInfo;
import auth.common.utils.JwtUtils;
import auth.common.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtTest {

    private static final String pubKeyPath = "D:\\tmp\\rsa\\rsa.pub";

    private static final String priKeyPath = "D:\\tmp\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo((int) 20L, "jack", "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTYwNDQxNDIxNX0.dReXe9ioXjHh_JhvmzVl95QxT0yhGZLc9724Dr3Gnwwvot2CYZjq3qRyv-z0H4T0fa4DE8TIzJuwOHkdB2yeCbYLIDKaWjuTSftmHtizij-viNWxnTY4RdzEHncL5Y6KXhlSLKliVL2EeiatrXCk4pkixE-Zbx1YKXZgOIDxyT4";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getuserid());
        System.out.println("userName: " + user.getUsername());
    }
}