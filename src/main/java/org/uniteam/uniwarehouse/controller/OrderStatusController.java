package org.uniteam.uniwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uniteam.uniwarehouse.domain.entity.OrderStatus;
import org.uniteam.uniwarehouse.service.OrderStatusService;

import static org.uniteam.uniwarehouse.util.constants.UriConstants.ORDER_STATUSES;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 19 дек. 2024
 **/
@RestController
@RequestMapping(value = ORDER_STATUSES)
public class OrderStatusController {
    private final OrderStatusService service;

    @Autowired
    public OrderStatusController(OrderStatusService service) {
        this.service = service;
    }

    @GetMapping
    public HttpEntity<?> get() {
        return ResponseEntity.ok(service.get());
    }

    @PostMapping
    public HttpEntity<?> post(@RequestBody OrderStatus data) {
        return ResponseEntity.ok(service.save(data));
    }

    @PutMapping
    public HttpEntity<?> put(@RequestBody OrderStatus data) {
        return ResponseEntity.ok(service.save(data));
    }
}
