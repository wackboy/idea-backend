package auth.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import user.item.UserApi;

/**
 * @Author: WackyBoy
 * @Date: 2020/11/4 15:15
 */
@FeignClient(value = "user-service")
public interface UserClient extends UserApi {

}
