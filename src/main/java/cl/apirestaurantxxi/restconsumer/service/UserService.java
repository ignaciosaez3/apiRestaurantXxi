package cl.apirestaurantxxi.restconsumer.service;


import cl.apirestaurantxxi.restconsumer.client.UserClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserClient userClient;

    @PostMapping
    public ResponseEntity<Object> UserSave(@RequestBody Object json) {
        return userClient.UserSave(json);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> UserDelete(@PathVariable String id) {
        return userClient.UserDelete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> UserUpdate(@PathVariable String id,@RequestBody Object json) {
        return userClient.UserUpdate(id,json);
    }
    @PutMapping("/updatePassword/{id}")
    public ResponseEntity<Object> UserUpdatePassword(@PathVariable String id,@RequestBody Object json) {
        return userClient.UserUpdatePass(id,json);
    }
    @GetMapping("/getAllUser")
    public ResponseEntity<Object> getAllUser() {
        return userClient.getAllUser();
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable String id) {
        return userClient.getUserById(id);
    }
}