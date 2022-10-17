package cl.apirestaurantxxi.restconsumer.client.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginClientRequest {

    private String username;
    private String password;
}
