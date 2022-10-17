package cl.apirestaurantxxi.restconsumer.service.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginServiceRequest {

    private String username;
    private String password;
}
