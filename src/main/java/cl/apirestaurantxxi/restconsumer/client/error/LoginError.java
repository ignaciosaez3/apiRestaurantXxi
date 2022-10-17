package cl.apirestaurantxxi.restconsumer.client.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginError {
    private String code;
    private String message;
    private String data;
}
