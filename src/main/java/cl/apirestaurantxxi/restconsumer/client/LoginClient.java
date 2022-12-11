package cl.apirestaurantxxi.restconsumer.client;


import cl.apirestaurantxxi.restconsumer.client.config.DefaultConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "${service.login.name}", url = "${service.url}", configuration = DefaultConfig.class)
public interface LoginClient {
    @PostMapping(value = "/v1/Auth/login", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> login(Object json);

    @PostMapping(value = "/v1/Auth/refreshToken", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> refreshToken(Object json);
}
