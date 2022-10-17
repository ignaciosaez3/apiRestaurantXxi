package cl.apirestaurantxxi.restconsumer.client.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginClientConfig {
    @Bean
    public LoginClientErrorDecoder errorDecoder(ObjectMapper objectMapper){
        return new LoginClientErrorDecoder(objectMapper);
    }
}
