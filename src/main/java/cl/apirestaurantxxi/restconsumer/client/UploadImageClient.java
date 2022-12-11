package cl.apirestaurantxxi.restconsumer.client;

import cl.apirestaurantxxi.restconsumer.client.config.ConfigImage;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "${service.image.name}", url = "${service.url}", configuration = ConfigImage.class)
public interface UploadImageClient {

    @PostMapping(value = "/UploadImage", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    String ImageSave(@RequestPart(value = "Image") MultipartFile image);
}
