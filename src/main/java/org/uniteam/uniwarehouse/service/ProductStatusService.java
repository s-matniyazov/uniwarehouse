package org.uniteam.uniwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniteam.uniwarehouse.domain.entity.ProductStatus;
import org.uniteam.uniwarehouse.repository.ProductStatusRepository;
import org.uniteam.uniwarehouse.service.base.BaseService;

import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 27 нояб. 2024
 **/
@Service
public class ProductStatusService extends BaseService {
    private final ProductStatusRepository repository;

    @Autowired
    public ProductStatusService(ProductStatusRepository repository) {
        this.repository = repository;
    }

    public List<ProductStatus> get() {
        return repository.findAll();
    }

    public ProductStatus save(ProductStatus data) {
        return repository.save(data);
    }
}
