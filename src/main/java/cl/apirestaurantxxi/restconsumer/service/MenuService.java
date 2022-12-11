package cl.apirestaurantxxi.restconsumer.service;

import cl.apirestaurantxxi.restconsumer.client.MenuClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MenuService {

    private final MenuClient menuClient;

    @GetMapping
    public ResponseEntity<Object> getFullMenu(){
        return menuClient.getFullMenu();

    }

    @GetMapping("/withCategory")
    public ResponseEntity<Object> getMenus() {
        return menuClient.getMenus();
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveMenu(@RequestBody Object json){
        return menuClient.saveMenu(json);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateMenu(@PathVariable String id,@RequestBody Object json) {
        return menuClient.updateMenu(id,json);

    }

    @PutMapping("/enableOrDisable/{id}")
    public ResponseEntity<Object> habilitarOrDesabilitar(@PathVariable String id,@RequestBody Object json) {
        return menuClient.habilitarOrDesabilitar(id,json);
    }

    @GetMapping("/stockCritical/{id}")
    public ResponseEntity<Object> getStockCriticalMenu(@PathVariable String id) {
        return menuClient.getStockCriticalMenu(id);
    }

    @GetMapping("/menuStockCritical")
    public ResponseEntity<Object> getMenuStockCritical() {
        return menuClient.getMenuStockCritical();
    }








}
