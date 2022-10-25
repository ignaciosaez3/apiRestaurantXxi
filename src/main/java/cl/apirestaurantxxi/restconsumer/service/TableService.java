package cl.apirestaurantxxi.restconsumer.service;


import cl.apirestaurantxxi.restconsumer.client.TableClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/table")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TableService {

    private final TableClient tableClient;

    @PostMapping
    public ResponseEntity<Object> TableSave(@RequestBody Object json) {
        return tableClient.TableSave(json);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> TableDelete(@PathVariable String id) {
        return tableClient.TableDelete(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> TableUpdate(@PathVariable String id,@RequestBody Object json) {
        return tableClient.TableUpdate(id,json);
    }

    @PutMapping("/updateTableState/{id}")
    public ResponseEntity<Object> TableUpdateState(@PathVariable String id,@RequestBody Object json) {
        return tableClient.TableUpdateState(id,json);
    }

    @GetMapping("/getAllTable")
    public ResponseEntity<Object> getAllTable() {
        return tableClient.getAllTable();
    }
}