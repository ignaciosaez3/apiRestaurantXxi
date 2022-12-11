package cl.apirestaurantxxi.restconsumer.client;

import cl.apirestaurantxxi.restconsumer.client.config.DefaultConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "${service.recipe.name}", url = "${service.url}", configuration = DefaultConfig.class)
public interface RecipeClient {

    @PostMapping(value = "/v1/Recipe", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> recipeSave(Object json);

    @PutMapping(value = "/v1/Recipe/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> recipeUpdate(@PathVariable String id, Object json);

    @DeleteMapping(value = "/v1/Recipe/{id}")
    ResponseEntity<Object> recipeDelete(@PathVariable String id);

    @GetMapping(value = "/v1/Recipe/menu/{id}", produces={MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getRecipeByIdMenu(@PathVariable String id);
}
