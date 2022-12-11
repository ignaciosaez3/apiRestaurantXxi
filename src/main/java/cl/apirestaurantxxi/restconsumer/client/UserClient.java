package cl.apirestaurantxxi.restconsumer.client;


import cl.apirestaurantxxi.restconsumer.client.config.DefaultConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "${service.user.name}", url = "${service.url}", configuration = DefaultConfig.class)
public interface UserClient {
    @PostMapping(value = "/v1/User", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> UserSave(Object json);

    @DeleteMapping(value = "/v1/User/{id}")
    ResponseEntity<Object> UserDelete(@PathVariable String id);

    @PutMapping(value = "/v1/User/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> UserUpdate(@PathVariable String id,Object json);

    @PutMapping(value = "/v1/User/updatePassword/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> UserUpdatePass(@PathVariable String id,Object json);

    @GetMapping(value = "/v1/User", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getAllUser();

    @GetMapping(value = "/v1/User/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getUserById(@PathVariable String id);
}