package cl.apirestaurantxxi.restconsumer.convert;

import cl.apirestaurantxxi.restconsumer.client.request.LoginClientRequest;
import cl.apirestaurantxxi.restconsumer.client.response.LoginClientResponse;
import cl.apirestaurantxxi.restconsumer.service.request.LoginServiceRequest;
import cl.apirestaurantxxi.restconsumer.service.response.LoginServiceResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginMapper {

    LoginServiceResponse mapLoginResponse(LoginClientResponse loginClientResponse);
    LoginClientRequest mapLoginRequest(LoginServiceRequest loginServiceRequest);

}

