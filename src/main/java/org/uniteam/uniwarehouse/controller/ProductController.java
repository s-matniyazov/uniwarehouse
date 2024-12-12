package org.uniteam.uniwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uniteam.uniwarehouse.data.dto.ProductDTO;
import org.uniteam.uniwarehouse.data.filter.ProductFilter;
import org.uniteam.uniwarehouse.util.constants.UriConstants;
import org.uniteam.uniwarehouse.service.ProductService;

import java.math.BigDecimal;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 22 нояб. 2024
 **/
@RestController
@RequestMapping(value = UriConstants.PRODUCTS)
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{productTypesId}")
    public HttpEntity<?> get(@PathVariable Integer productTypesId, @RequestParam(value = "productStatusesId", required = false) Integer productStatusesId,
                             @RequestParam(value = "name", required = false) String name, @RequestParam(value = "price", required = false) BigDecimal price) {
        return ResponseEntity.ok(service.get(new ProductFilter(
                name,
                productTypesId,
                productStatusesId,
                price
        )));
    }

    @PostMapping
    public HttpEntity<?> post(@RequestBody ProductDTO data) {
        return ResponseEntity.ok(service.save(data));
    }

    @PutMapping
    public HttpEntity<?> put(@RequestBody ProductDTO data) {
        return ResponseEntity.ok(service.save(data));
    }
}
