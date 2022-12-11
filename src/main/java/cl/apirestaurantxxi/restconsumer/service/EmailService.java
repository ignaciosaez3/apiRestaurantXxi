package cl.apirestaurantxxi.restconsumer.service;

import cl.apirestaurantxxi.restconsumer.client.EmailClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailService {

    private final EmailClient emailClient;
    @PostMapping
    public ResponseEntity<Object> sendEmail(@RequestBody Object json){
        return emailClient.sendEmail(json);
    }
}
