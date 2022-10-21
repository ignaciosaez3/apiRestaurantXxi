package cl.apirestaurantxxi.restconsumer.client;

import cl.apirestaurantxxi.restconsumer.client.config.DefaultConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${service.menu.name}", url = "${service.url}", configuration = DefaultConfig.class)
public interface MenuClient {

    @GetMapping(value = "/Menu/withCategory", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getMenus();


}
