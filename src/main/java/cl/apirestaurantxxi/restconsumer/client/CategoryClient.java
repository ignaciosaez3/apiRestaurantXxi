package cl.apirestaurantxxi.restconsumer.client;

import cl.apirestaurantxxi.restconsumer.client.config.DefaultConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${service.category.name}", url = "${service.url}", configuration = DefaultConfig.class)
public interface CategoryClient {
    @GetMapping(value = "/v1/Category", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getCategory();

    @GetMapping(value = "/v1/Category/{id}", produces={MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getCategoryById(@PathVariable String id);
}
