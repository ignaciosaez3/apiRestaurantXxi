package cl.apirestaurantxxi.restconsumer.exception;

import cl.apirestaurantxxi.restconsumer.client.ExceptionCachilupi;
import cl.apirestaurantxxi.restconsumer.client.ExceptionCachilupi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ExceptionCachilupi.class)
    protected ResponseEntity<Object> handleDataIntegrity(ExceptionCachilupi ex) {
        var response = ex.getResponse();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        response.headers().forEach((key, value) -> {
            map.add(key, StringUtils.hasLength(key) ? String.join(";", value) : "");
        });
        return new ResponseEntity<>(ex.getBody(), map, response.status());
    }


}
