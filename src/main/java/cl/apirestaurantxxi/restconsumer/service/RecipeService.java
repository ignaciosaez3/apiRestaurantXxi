package cl.apirestaurantxxi.restconsumer.service;

import cl.apirestaurantxxi.restconsumer.client.RecipeClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RecipeService {

    private final RecipeClient recipeClient;

    @PostMapping
    public ResponseEntity<Object> recipeSave(@RequestBody Object json) {
        return recipeClient.recipeSave(json);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> recipeUpdate(@PathVariable String id,@RequestBody Object json) {
        return recipeClient.recipeUpdate(id,json);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> recipeDelete(@PathVariable String id) {
        return recipeClient.recipeDelete(id);
    }
    @GetMapping("/getRecipeByIdMenu/{id}")
    public ResponseEntity<Object> getRecipeByIdMenu(@PathVariable String id) {
        return recipeClient.getRecipeByIdMenu(id);
    }
}
