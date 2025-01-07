package org.uniteam.uniwarehouse.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniteam.uniwarehouse.domain.entity.ProductType;
import org.uniteam.uniwarehouse.repository.ProductTypeRepository;

import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 22 нояб. 2024
 **/
@Service
public class ProductTypeService {
    private final ProductTypeRepository repository;

    @Autowired
    public ProductTypeService(ProductTypeRepository repository) {
        this.repository = repository;
    }

    public List<ProductType> get() {
        return repository.findAll();
    }

    @Transactional
    public ProductType save(ProductType data) {
        return repository.save(data);
    }
}
