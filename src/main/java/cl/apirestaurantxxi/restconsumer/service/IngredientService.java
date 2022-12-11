package cl.apirestaurantxxi.restconsumer.service;

import cl.apirestaurantxxi.restconsumer.client.IngredientClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IngredientService {
    private final IngredientClient ingredientClient;

    @GetMapping
    public ResponseEntity<Object> getIngredient() {
        return ingredientClient.getIngredient();
    }

    @GetMapping("/orders")
    public ResponseEntity<Object> getIngredientOrders() {
        return ingredientClient.getIngredientOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderIngredientById(@PathVariable String id) {
        return ingredientClient.getOrderIngredientById(id);
    }
    @GetMapping("/detailsOrders")
    public ResponseEntity<Object> getListDetailsOrders(){
        return ingredientClient.getListOfDetailsOrder();
    }
    @GetMapping("/detailsOrders/{id}")
    public ResponseEntity<Object> getDetailsOrderById(@PathVariable String id) {
        return ingredientClient.getDetailsOrderById(id);
    }

    @PostMapping("/petitionManage")
    public ResponseEntity<Object> adminOrderSupplies(@RequestBody Object json) {
        return ingredientClient.adminOrderSupplies(json);
    }
    @PostMapping("/save")
    public ResponseEntity<Object> saveIngredient(@RequestBody Object json){
        return ingredientClient.saveIngredient(json);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateIngredient(@PathVariable String id,@RequestBody Object json) {
        return ingredientClient.updateIngredient(id,json);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteIngredient(@PathVariable String id) {
        return ingredientClient.deleteIngredient(id);
    }

}
