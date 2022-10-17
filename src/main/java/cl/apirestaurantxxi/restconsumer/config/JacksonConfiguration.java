package cl.apirestaurantxxi.restconsumer.config;

import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.databind.DeserializationFeature.*;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

@Configuration
public class JacksonConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        return new Jackson2ObjectMapperBuilder()
                .modules(new JavaTimeModule(), new Jdk8Module())
                .serializationInclusion(NON_EMPTY)
                .featuresToDisable(WRITE_DATES_AS_TIMESTAMPS)
                .featuresToDisable(ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
                .featuresToDisable(FAIL_ON_UNKNOWN_PROPERTIES)
                .featuresToEnable(ACCEPT_SINGLE_VALUE_AS_ARRAY)
                .simpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSX");
    }
}
