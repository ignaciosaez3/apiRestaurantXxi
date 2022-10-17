package cl.apirestaurantxxi.restconsumer.service.response;

import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
public class LoginServiceResponse {
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
