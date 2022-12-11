package cl.apirestaurantxxi.restconsumer.client.config;

import cl.apirestaurantxxi.restconsumer.exception.ExceptionCachilupi;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        throw new ExceptionCachilupi(response);
    }
}
