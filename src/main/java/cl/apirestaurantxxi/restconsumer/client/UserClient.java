package cl.apirestaurantxxi.restconsumer.client;


import cl.apirestaurantxxi.restconsumer.client.config.DefaultConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(name = "${service.user.name}", url = "${service.url}", configuration = DefaultConfig.class)
public interface UserClient {
    @PostMapping(value = "/User", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> UserSave(Object json);

    @DeleteMapping(value = "/User/{id}")
    ResponseEntity<Object> UserDelete(@PathVariable String id);

    @PutMapping(value = "/User/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> UserUpdate(@PathVariable String id,Object json);

    @PutMapping(value = "/User/updatePassword/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> UserUpdatePass(@PathVariable String id,Object json);
}