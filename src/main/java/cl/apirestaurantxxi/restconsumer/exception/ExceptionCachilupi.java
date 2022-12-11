package cl.apirestaurantxxi.restconsumer.exception;

import feign.Response;
import feign.Util;
import lombok.Getter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Getter
public class ExceptionCachilupi extends RuntimeException {

    private Response response;
    private String body;

    public ExceptionCachilupi(Response response) {
        this.response = response;
        try {
            this.body = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
