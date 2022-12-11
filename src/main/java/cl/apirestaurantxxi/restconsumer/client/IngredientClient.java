package cl.apirestaurantxxi.restconsumer.client;

import cl.apirestaurantxxi.restconsumer.client.config.DefaultConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "${service.ingredient.name}", url = "${service.url}", configuration = DefaultConfig.class)
public interface IngredientClient {
    @GetMapping(value = "/v1/Ingredient/orders", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getIngredientOrders();

    @GetMapping(value = "/v1/Ingredient/order/{id}", produces={MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getOrderIngredientById(@PathVariable String id);

    @GetMapping(value = "/v1/Ingredient/detailOrders", produces={MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getListOfDetailsOrder();

    @GetMapping(value = "/v1/Ingredient/detailOrders/{id}", produces={MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getDetailsOrderById(@PathVariable String id);

    @PostMapping(value = "/v1/Ingredient/petitionManage", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> adminOrderSupplies(Object json);

    @PostMapping(value = "/v1/Ingredient",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> saveIngredient(Object json);

    @PutMapping(value = "/v1/Ingredient/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> updateIngredient(@PathVariable String id,Object json);

    @DeleteMapping(value = "/v1/Ingredient/{id}")
    ResponseEntity<Object> deleteIngredient(@PathVariable String id);

    @GetMapping(value = "/v1/Ingredient", produces={MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getIngredient();
}
