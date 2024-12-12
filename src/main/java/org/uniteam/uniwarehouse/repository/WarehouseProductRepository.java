package org.uniteam.uniwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uniteam.uniwarehouse.domain.entity.WarehouseProduct;

import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 28 нояб. 2024
 **/
public interface WarehouseProductRepository extends JpaRepository<WarehouseProduct, Integer> {
    List<WarehouseProduct> findAllByWarehouse_Id(Integer warehouseId);
    List<WarehouseProduct> findAllByWarehouseId(Integer warehouseId);
}
