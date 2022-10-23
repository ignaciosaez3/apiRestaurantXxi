package cl.apirestaurantxxi.restconsumer.service;


import cl.apirestaurantxxi.restconsumer.client.TableSaveClient;
import cl.apirestaurantxxi.restconsumer.client.UserSaveClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/table")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TableSaveService {

    private final TableSaveClient tableSaveClient;

    @PostMapping
    public ResponseEntity<Object> UserSave(@RequestBody Object json) {
        return tableSaveClient.TableSave(json);
    }
}