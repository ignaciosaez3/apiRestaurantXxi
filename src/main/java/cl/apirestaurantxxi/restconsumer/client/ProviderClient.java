package cl.apirestaurantxxi.restconsumer.client;

import cl.apirestaurantxxi.restconsumer.client.config.DefaultConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "${service.provider.name}", url = "${service.url}", configuration = DefaultConfig.class)
public interface ProviderClient {
    @GetMapping(value = "/v1/Providers", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getProvider();

    @GetMapping(value = "/v1/Providers/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getProviderById(@PathVariable String id);

    @PutMapping(value = "/v1/Providers/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> updateProviders(@PathVariable String id,Object json);

    @DeleteMapping(value = "/v1/Providers/{id}")
    ResponseEntity<Object> deleteProviders(@PathVariable String id);

    @PostMapping(value = "/v1/Providers", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> saveProviders(Object json);

}
