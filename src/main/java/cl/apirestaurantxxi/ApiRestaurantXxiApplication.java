package cl.apirestaurantxxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableFeignClients
public class ApiRestaurantXxiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestaurantXxiApplication.class, args);


    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedOrigins("*")
                        .allowCredentials(false)
                        .allowedHeaders("*")
                        .exposedHeaders("*")
                        .maxAge(60 * 30)
                        .allowedMethods("*");
            }
        };
    }

}
