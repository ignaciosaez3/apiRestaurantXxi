package cl.apirestaurantxxi.restconsumer.client;


import cl.apirestaurantxxi.restconsumer.client.request.LoginClientRequest;
import cl.apirestaurantxxi.restconsumer.client.response.LoginClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "${service.login.name}", url = "${service.login.url}")
public interface LoginClient {
    @PostMapping(value = "/api/v1/Auth/login", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    LoginClientResponse login(LoginClientRequest loginClientRequest);
}