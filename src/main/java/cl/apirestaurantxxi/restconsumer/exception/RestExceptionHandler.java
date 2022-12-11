package cl.apirestaurantxxi.restconsumer.exception;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
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

    @Value("${service.image.validations.min_pixels}")
    private String pixelValidation;

    @ExceptionHandler(ExceptionCachilupi.class)
    protected ResponseEntity<Object> handleDataIntegrity(ExceptionCachilupi ex) {
        var response = ex.getResponse();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        response.headers().forEach((key, value) -> {
            map.add(key, StringUtils.hasLength(key) ? String.join(";", value) : "");
        });
        return new ResponseEntity<>(ex.getBody(), map, response.status());
    }

    @ExceptionHandler(ImagenInvalidaException.class)
    protected ResponseEntity<Object> handleDataIntegrity(ImagenInvalidaException ex) {
        return new ResponseEntity<>(JsonError.builder().code("001").message(pixelValidation).build(), HttpStatus.BAD_REQUEST);
    }

    @Data
    @Builder
    public static class JsonError {

        private String code;
        private String message;
    }
}




