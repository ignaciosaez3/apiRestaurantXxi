package cl.apirestaurantxxi.restconsumer.service;

import cl.apirestaurantxxi.restconsumer.client.BillClient;
import cl.apirestaurantxxi.restconsumer.client.RolClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bill")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BillService {

    private final BillClient billClient;

    @GetMapping
    public ResponseEntity<Object> getBillOfDay() {
        return billClient.getBillOfDay();
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Object> getDetailOfBill(@PathVariable String id) {
        return billClient.getDetailOfBill(id);
    }

    @PostMapping("/getDetailSales")
    public ResponseEntity<Object> getDetailOfSale(@RequestBody Object json) {
        return billClient.getDetailOfSale(json);
    }

    @PostMapping("/getSales")
    public ResponseEntity<Object> getQuantityOfSales(@RequestBody Object json) {
        return billClient.getQuantityOfSales(json);
    }


}
