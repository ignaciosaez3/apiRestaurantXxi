package cl.apirestaurantxxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiRestaurantXxiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestaurantXxiApplication.class, args);
    }

}
