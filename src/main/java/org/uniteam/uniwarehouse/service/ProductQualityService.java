package org.uniteam.uniwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniteam.uniwarehouse.domain.entity.ProductQuality;
import org.uniteam.uniwarehouse.repository.ProductQualityRepository;
import org.uniteam.uniwarehouse.service.base.BaseService;

import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 27 нояб. 2024
 **/
@Service
public class ProductQualityService extends BaseService {
    private final ProductQualityRepository repository;

    @Autowired
    public ProductQualityService(ProductQualityRepository repository) {
        this.repository = repository;
    }

    public List<ProductQuality> get() {
        return repository.findAll();
    }

    public ProductQuality save(ProductQuality data) {
        return repository.save(data);
    }
}
