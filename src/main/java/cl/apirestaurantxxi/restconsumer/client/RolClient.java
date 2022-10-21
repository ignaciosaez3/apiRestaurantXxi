package cl.apirestaurantxxi.restconsumer.client;

import cl.apirestaurantxxi.restconsumer.client.config.DefaultConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${service.rol.name}", url = "${service.url}", configuration = DefaultConfig.class)
public interface RolClient {

    @GetMapping(value = "/Role", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getRoles();


}
