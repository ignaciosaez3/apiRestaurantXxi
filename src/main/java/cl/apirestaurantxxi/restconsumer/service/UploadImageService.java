package cl.apirestaurantxxi.restconsumer.service;

import cl.apirestaurantxxi.restconsumer.client.UploadImageClient;
import cl.apirestaurantxxi.restconsumer.exception.ImagenInvalidaException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/upLoadImage")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UploadImageService {


    private static final Integer MIN_PIXEL_VALIDATION = 500;

    private final UploadImageClient uploadImageClient;

    @PostMapping
    public String ImageSave(@RequestParam(name = "image") MultipartFile json) throws ImagenInvalidaException {
        validateImageSize(json);
        return uploadImageClient.ImageSave(json);
    }

    private void validateImageSize(MultipartFile json) throws ImagenInvalidaException {
        BufferedImage image;
        try {
            image = ImageIO.read(json.getInputStream());
        } catch (IOException e) {
            throw new ImagenInvalidaException();
        }

        if (image == null) {
            throw new ImagenInvalidaException();
        }

        int width = image.getWidth();
        int height = image.getHeight();

        if (width < MIN_PIXEL_VALIDATION || height < MIN_PIXEL_VALIDATION) {
            throw new ImagenInvalidaException();
        }
    }
}
