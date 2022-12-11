package cl.apirestaurantxxi.restconsumer.client;

import cl.apirestaurantxxi.restconsumer.client.config.DefaultConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "${service.menu.name}", url = "${service.url}", configuration = DefaultConfig.class)
public interface MenuClient {

    @GetMapping(value = "/v1/Menu/withCategory", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getMenus();

    @GetMapping(value = "/v1/Menu", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getFullMenu();

    @PostMapping(value = "/v1/Menu", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> saveMenu(Object json);

    @PutMapping(value= "/v1/Menu/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> updateMenu(@PathVariable String id , Object json);

    @PutMapping(value = "/v1/Menu/enableOrDisable/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> habilitarOrDesabilitar(@PathVariable String id,Object json);

    @GetMapping(value = "/v1/Menu/stockCritical/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getStockCriticalMenu(@PathVariable String id);

    @GetMapping(value = "/v1/Menu/menuStockCritical", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getMenuStockCritical();



}
