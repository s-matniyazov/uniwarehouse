package org.uniteam.uniwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uniteam.uniwarehouse.data.dto.OrderDTO;
import org.uniteam.uniwarehouse.data.dto.OrderModelDTO;
import org.uniteam.uniwarehouse.data.dto.OrderWorkDTO;
import org.uniteam.uniwarehouse.service.OrderService;

import java.util.List;

import static org.uniteam.uniwarehouse.util.constants.UriConstants.ORDERS;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 18 дек. 2024
 **/
@RestController
@RequestMapping(value = ORDERS)
public class OrderController {
    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public HttpEntity<?> get() {
        return ResponseEntity.ok(service.get());
    }

    @PostMapping
    public HttpEntity<?> post(@RequestBody OrderDTO data) {
        return ResponseEntity.ok(service.save(data));
    }

    @PostMapping("model")
    public HttpEntity<?> modelPost(@RequestBody OrderModelDTO data) {
        return ResponseEntity.ok(service.modelSave(data));
    }

    @PostMapping("{orderId}/work")
    public HttpEntity<?> workPost(@PathVariable Integer orderId, @RequestBody List<OrderWorkDTO> data) {
        return ResponseEntity.ok(service.workSave(orderId, data));
    }
}
