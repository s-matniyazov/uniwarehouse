package org.uniteam.uniwarehouse.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.uniteam.uniwarehouse.service.ResourceService;

import static org.uniteam.uniwarehouse.util.constants.UriConstants.RESOURCES;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 07 янв. 2025
 **/
@RestController
@RequestMapping(value = RESOURCES)
public class ResourceController {
    private final ResourceService service;

    public ResourceController(ResourceService service) {
        this.service = service;
    }

    @GetMapping(value = "{token}")
    public void get(@PathVariable String token, HttpServletResponse response) {
        service.get(token, response);
    }

    @PostMapping
    public HttpEntity<?> post(MultipartFile file) {
        return ResponseEntity.ok(service.save(file));
    }

}
