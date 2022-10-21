package cl.apirestaurantxxi.restconsumer.service;

import cl.apirestaurantxxi.restconsumer.client.RolClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Role")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RolService {

    private final RolClient rolClient;

    @GetMapping
    public ResponseEntity<Object> getRoles() {
        return rolClient.getRoles();
    }


}
