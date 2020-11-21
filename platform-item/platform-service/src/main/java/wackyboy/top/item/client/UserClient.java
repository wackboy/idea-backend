package wackyboy.top.item.client;

import org.springframework.cloud.openfeign.FeignClient;
import user.item.UserApi;

@FeignClient(value = "user-service")
public interface UserClient extends UserApi {

}
