package cl.apirestaurantxxi.restconsumer.client.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class DefaultConfig {

    @Bean
    public DefaultErrorDecoder errorDecoder() {
        return new DefaultErrorDecoder();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert attributes != null;
            HttpServletRequest request = attributes.getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();

            if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();
                    String values = request.getHeader(name);
                    if ("content-length".equalsIgnoreCase(name)) {
                        continue;
                    }

                    requestTemplate.header(name, values);
                }
            }
        };
    }

}
