package cl.apirestaurantxxi.restconsumer.service;

import cl.apirestaurantxxi.restconsumer.client.LoginClient;
import cl.apirestaurantxxi.restconsumer.convert.LoginMapper;
import cl.apirestaurantxxi.restconsumer.service.request.LoginServiceRequest;
import cl.apirestaurantxxi.restconsumer.service.response.LoginServiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginService {

    private final LoginClient loginClient;
    private final LoginMapper loginMapper;

    @PostMapping
    public ResponseEntity<LoginServiceResponse> login(@RequestBody LoginServiceRequest loginServiceRequest) {
        var response = loginClient.login(loginMapper.mapLoginRequest(loginServiceRequest));
        return new ResponseEntity<>(loginMapper.mapLoginResponse(response), HttpStatus.OK);
    }


}
