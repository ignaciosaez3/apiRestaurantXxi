package cl.apirestaurantxxi.restconsumer.service;

import cl.apirestaurantxxi.restconsumer.client.ProviderClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proved")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProviderService {

    private final ProviderClient providerClient;

    @GetMapping
    public ResponseEntity<Object> getCategory() {
        return providerClient.getProvider();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable String id) {
        return providerClient.getProviderById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProviders(@PathVariable String id,@RequestBody Object json) {
        return providerClient.updateProviders(id,json);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProviders(@PathVariable String id) {
        return providerClient.deleteProviders(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveProviders(@RequestBody Object json) {
        return providerClient.saveProviders(json);
    }



}
