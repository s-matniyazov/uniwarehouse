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
import org.uniteam.uniwarehouse.domain.entity.ProductStatus;
import org.uniteam.uniwarehouse.service.ProductStatusService;
import org.uniteam.uniwarehouse.util.constants.UriConstants;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 27 нояб. 2024
 **/
@RestController
@RequestMapping(value = UriConstants.PRODUCT_STATUSES)
public class ProductStatusController {
    private final ProductStatusService service;

    @Autowired
    public ProductStatusController(ProductStatusService service) {
        this.service = service;
    }

    @GetMapping
    public HttpEntity<?> get() {
        return ResponseEntity.ok(service.get());
    }

    @PostMapping
    public HttpEntity<?> post(@RequestBody ProductStatus data) {
        return ResponseEntity.ok(service.save(data));
    }

    @PutMapping
    public HttpEntity<?> put(@RequestBody ProductStatus data) {
        return ResponseEntity.ok(service.save(data));
    }
}
