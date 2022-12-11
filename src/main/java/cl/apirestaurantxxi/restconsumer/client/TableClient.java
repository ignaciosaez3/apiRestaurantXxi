package cl.apirestaurantxxi.restconsumer.client;


import cl.apirestaurantxxi.restconsumer.client.config.DefaultConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "${service.table.name}", url = "${service.url}", configuration = DefaultConfig.class)
public interface TableClient {
    @PostMapping(value = "/v1/Table", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> TableSave(Object json);

    @DeleteMapping(value = "/v1/Table/{id}")
    ResponseEntity<Object> TableDelete(@PathVariable String id);

    @PutMapping(value = "/v1/Table/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> TableUpdate(@PathVariable String id,Object json);

    @PutMapping(value = "/v1/Table/updateTableState/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> TableUpdateState(@PathVariable String id,Object json);

    @GetMapping(value = "/v1/Table/action/A", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getAllTable();
}