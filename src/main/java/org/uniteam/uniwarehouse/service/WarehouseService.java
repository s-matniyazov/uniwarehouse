package org.uniteam.uniwarehouse.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniteam.uniwarehouse.data.dto.WarehouseDTO;
import org.uniteam.uniwarehouse.domain.entity.ProductType;
import org.uniteam.uniwarehouse.domain.entity.Warehouse;
import org.uniteam.uniwarehouse.domain.entity.WarehouseProduct;
import org.uniteam.uniwarehouse.repository.ProductRepository;
import org.uniteam.uniwarehouse.repository.ProductTypeRepository;
import org.uniteam.uniwarehouse.repository.WarehouseProductRepository;
import org.uniteam.uniwarehouse.repository.WarehouseRepository;
import org.uniteam.uniwarehouse.service.base.BaseService;
import org.uniteam.uniwarehouse.util.exceptions.NotFoundException;

import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 23 нояб. 2024
 **/
@Service
public class WarehouseService extends BaseService {
    private final WarehouseRepository repository;
    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final WarehouseProductRepository warehouseProductRepository;

    @Autowired
    public WarehouseService(WarehouseRepository repository, ProductRepository productRepository, ProductTypeRepository productTypeRepository, WarehouseProductRepository warehouseProductRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
        this.warehouseProductRepository = warehouseProductRepository;
    }

    public List<Warehouse> get() {
        return repository.findAll();
    }

    @Transactional
    public Warehouse save(WarehouseDTO data) {
        ProductType productType = productTypeRepository.findById(data.productTypeId()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("product.type.not_found")));

        Warehouse wSave = repository.save(new Warehouse(data.name(), productType));

        warehouseProductRepository.saveAll(
                data.products()
                        .stream()
                        .map(it -> new WarehouseProduct(
                                it.amount(),
                                productRepository.findById(it.productId()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("product.not_found"))),
                                wSave
                        ))
                        .toList()
        );

        return wSave;
    }

    public List<WarehouseProduct> getProducts(Integer warehouseId) {
        return warehouseProductRepository.findAllByWarehouse_Id(warehouseId);
    }
}
