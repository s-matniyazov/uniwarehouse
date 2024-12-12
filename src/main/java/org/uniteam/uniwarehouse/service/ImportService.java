package org.uniteam.uniwarehouse.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.uniteam.uniwarehouse.data.dto.ImportDTO;
import org.uniteam.uniwarehouse.domain.entity.Import;
import org.uniteam.uniwarehouse.domain.entity.ImportProduct;
import org.uniteam.uniwarehouse.domain.entity.Warehouse;
import org.uniteam.uniwarehouse.domain.entity.WarehouseProduct;
import org.uniteam.uniwarehouse.repository.ImportRepository;
import org.uniteam.uniwarehouse.repository.ProductRepository;
import org.uniteam.uniwarehouse.repository.WarehouseProductRepository;
import org.uniteam.uniwarehouse.repository.WarehouseRepository;
import org.uniteam.uniwarehouse.service.base.BaseService;
import org.uniteam.uniwarehouse.util.exceptions.NotFoundException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 30 нояб. 2024
 **/
@Service
public class ImportService extends BaseService {

    private final ImportRepository repository;

    private final WarehouseRepository warehouseRepository;

    private final ProductRepository productRepository;

    private final WarehouseProductRepository warehouseProductRepository;

    public ImportService(ImportRepository repository, WarehouseRepository warehouseRepository, ProductRepository productRepository, WarehouseProductRepository warehouseProductRepository) {
        this.repository = repository;
        this.warehouseRepository = warehouseRepository;
        this.productRepository = productRepository;
        this.warehouseProductRepository = warehouseProductRepository;
    }

    public List<Import> get() {
        return repository.findAll();
    }

    @Transactional
    public Import save(ImportDTO data) {
        Warehouse warehouse = warehouseRepository.findById(data.warehouseId()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("warehouse.not_found")));

        Import importP = new Import(
                new Timestamp(data.importDate().getTime()),
                data.sender(),
                data.receiver(),
                warehouse
        );

        List<WarehouseProduct> wProducts = data.products().stream()
                .map(it -> warehouseProductRepository.findById(it.productId()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("warehouse.product.not_found"))))
                .toList();

        List<ImportProduct> iProducts = data.products().stream()
                .map(it -> new ImportProduct(
                        it.amount(),
                        it.price(),
                        productRepository.findById(it.productId()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("product.not_found"))),
                        importP
                ))
                .toList();

        wProducts.forEach(it -> {
            Optional<ImportProduct> importProduct = iProducts.stream().filter(iP -> iP.getProduct().getId().equals(it.getProduct().getId())).findAny();

            importProduct.ifPresent(product -> it.setAmount(it.getAmount() + product.getAmount()));
        });

        importP.setProducts(iProducts);

        return repository.save(importP);
    }
}
