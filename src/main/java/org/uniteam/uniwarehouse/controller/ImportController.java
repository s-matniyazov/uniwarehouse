package org.uniteam.uniwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uniteam.uniwarehouse.data.dto.ImportDTO;
import org.uniteam.uniwarehouse.service.ImportService;
import org.uniteam.uniwarehouse.util.constants.UriConstants;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 30 нояб. 2024
 **/
@RestController
@RequestMapping(UriConstants.IMPORTS)
public class ImportController {
    private final ImportService service;

    @Autowired
    public ImportController(ImportService service) {
        this.service = service;
    }

    @GetMapping
    public HttpEntity<?> get() {
        return ResponseEntity.ok(service.get());
    }

    @PostMapping
    public HttpEntity<?> post(@RequestBody ImportDTO data) {
        return ResponseEntity.ok(service.save(data));
    }
}
