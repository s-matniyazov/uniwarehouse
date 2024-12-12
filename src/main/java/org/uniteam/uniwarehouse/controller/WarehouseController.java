package org.uniteam.uniwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uniteam.uniwarehouse.util.constants.UriConstants;
import org.uniteam.uniwarehouse.data.dto.WarehouseDTO;
import org.uniteam.uniwarehouse.service.WarehouseService;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 23 нояб. 2024
 **/
@RestController
@RequestMapping(value = UriConstants.WAREHOUSE)
public class WarehouseController {
    private final WarehouseService service;

    @Autowired
    public WarehouseController(WarehouseService service) {
        this.service = service;
    }

    @GetMapping
    public HttpEntity<?> get() {
        return ResponseEntity.ok(service.get());
    }

    @PostMapping
    public HttpEntity<?> post(@RequestBody WarehouseDTO data) {
        return ResponseEntity.ok(service.save(data));
    }

    @PutMapping
    public HttpEntity<?> put(@RequestBody WarehouseDTO data) {
        return ResponseEntity.ok(service.save(data));
    }

    @GetMapping("/{id}/products")
    public HttpEntity<?> getProducts(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getProducts(id));
    }
}
