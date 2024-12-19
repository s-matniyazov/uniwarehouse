package org.uniteam.uniwarehouse.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.uniteam.uniwarehouse.data.dto.ProductDTO;
import org.uniteam.uniwarehouse.data.filter.ProductFilter;
import org.uniteam.uniwarehouse.domain.entity.*;
import org.uniteam.uniwarehouse.domain.filters.ProductFilterSpecifications;
import org.uniteam.uniwarehouse.repository.*;
import org.uniteam.uniwarehouse.service.base.BaseService;
import org.uniteam.uniwarehouse.util.exceptions.NotFoundException;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 22 нояб. 2024
 **/
@Service
public class ProductService extends BaseService {
    private final ProductRepository repository;
    private final UnitRepository unitRepository;
    private final ProductQualityRepository qualityRepository;
    private final ProductTypeRepository productTypeRepository;
    private final ProductStatusRepository productStatusRepository;

    @Autowired
    public ProductService(ProductRepository repository, UnitRepository unitRepository, ProductQualityRepository qualityRepository,
                          ProductTypeRepository productTypeRepository, ProductStatusRepository productStatusRepository) {
        this.repository = repository;
        this.unitRepository = unitRepository;
        this.qualityRepository = qualityRepository;
        this.productTypeRepository = productTypeRepository;
        this.productStatusRepository = productStatusRepository;
    }

    public List<Product> get(ProductFilter filters) {
        Specification<Product> spec =
                Specification.where(ProductFilterSpecifications.hasName(filters.name()))
                        .and(ProductFilterSpecifications.hasStatus(
                                filters.productStatusesId() != null
                                        ? productStatusRepository.findById(filters.productStatusesId()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("product.status.not_found")))
                                        : null)
                        ).and(ProductFilterSpecifications.hasType(
                                productTypeRepository.findById(filters.productTypesId()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("product.type.not_found"))))
                        );

        return repository.findAll(spec);
    }

    @Transactional
    public Product save(ProductDTO data) {
        Unit unit = unitRepository.findById(data.unitId()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("product.unit.not_found")));
        ProductQuality quality = qualityRepository.findById(data.qualityId()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("product.quality.not_found")));
        ProductType productType = productTypeRepository.findById(data.productTypesId()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("product.type.not_found")));
        ProductStatus status = productStatusRepository.findByIsInitial(true).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("product.status.not_found")));

        Product product = new Product(
                data.nameUz(), data.nameUk(), data.nameRu(), data.nameEn(),
                data.amount(),
                BigDecimal.valueOf(data.price()),
                data.tinCode(),
                unit,
                quality,
                productType,
                status
        );

        if (data.id() != null) {
            product.setId(data.id());
        }

        return repository.save(product);
    }
}
