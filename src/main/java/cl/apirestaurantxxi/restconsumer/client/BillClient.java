package cl.apirestaurantxxi.restconsumer.client;


import cl.apirestaurantxxi.restconsumer.client.config.DefaultConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "${service.bill.name}", url = "${service.url}", configuration = DefaultConfig.class)
public interface BillClient {
    @GetMapping(value = "/v1/Bill/OfDay", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getBillOfDay();

    @GetMapping(value = "/v1/Bill/detail/{id}", produces={MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getDetailOfBill(@PathVariable String id);

    @PostMapping(value = "/v1/Bill/getDetailSales", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getDetailOfSale(Object json);

    @PostMapping(value = "/v1/Bill/getSales", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> getQuantityOfSales(Object json);

}
