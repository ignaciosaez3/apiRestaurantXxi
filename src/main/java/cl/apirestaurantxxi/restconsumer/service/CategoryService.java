package cl.apirestaurantxxi.restconsumer.service;

import cl.apirestaurantxxi.restconsumer.client.CategoryClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryService {

    private final CategoryClient categoryClient;

    @GetMapping
    public ResponseEntity<Object> getCategory() {
        return categoryClient.getCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable String id) {
        return categoryClient.getCategoryById(id);
    }

}
