package cl.apirestaurantxxi.restconsumer.client.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginClientResponse {
    private String code;
    private String message;
    private Data data;

    @lombok.Data
    public static class Data {
        private String role;
        private String token;
        private String refreshToken;
    }
}
