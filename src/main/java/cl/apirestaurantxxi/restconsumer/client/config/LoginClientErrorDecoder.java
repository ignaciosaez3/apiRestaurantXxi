package cl.apirestaurantxxi.restconsumer.client.config;

import cl.apirestaurantxxi.restconsumer.client.error.LoginError;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LoginClientErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper;

    public LoginClientErrorDecoder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Exception decode(String methodKey, Response response) {

        LoginError loginError = buildResponse(response.body());

        if (response.status() >= 500 && response.status() < 600) {
            log.error("ERROR RAUL -> {}", loginError);

        }
        return new Default().decode(methodKey, response);
    }

    private LoginError buildResponse(Response.Body body) {
        try {
            String response = Util.toString(body.asReader());
            return objectMapper.readValue(response, LoginError.class);
        } catch (IOException ex) {
            log.error("IO exception {} ", "context", ex);
            throw new RuntimeException(ex);
        }
    }

}
