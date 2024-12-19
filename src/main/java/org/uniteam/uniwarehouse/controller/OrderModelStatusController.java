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
import org.uniteam.uniwarehouse.domain.entity.OrderModelStatus;
import org.uniteam.uniwarehouse.service.OrderModelStatusService;

import static org.uniteam.uniwarehouse.util.constants.UriConstants.ORDER_MODEL_STATUSES;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 19 дек. 2024
 **/
@RestController
@RequestMapping(value = ORDER_MODEL_STATUSES)
public class OrderModelStatusController {
    private final OrderModelStatusService service;

    @Autowired
    public OrderModelStatusController(OrderModelStatusService service) {
        this.service = service;
    }

    @GetMapping
    public HttpEntity<?> get() {
        return ResponseEntity.ok(service.get());
    }

    @PostMapping
    public HttpEntity<?> post(@RequestBody OrderModelStatus data) {
        return ResponseEntity.ok(service.save(data));
    }

    @PutMapping
    public HttpEntity<?> put(@RequestBody OrderModelStatus data) {
        return ResponseEntity.ok(service.save(data));
    }
}
