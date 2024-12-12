package org.uniteam.uniwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uniteam.uniwarehouse.domain.entity.ProductStatus;

import java.util.Optional;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 27 нояб. 2024
 **/
public interface ProductStatusRepository extends JpaRepository<ProductStatus, Integer> {
    Optional<ProductStatus> findByIsInitial(Boolean isInitial);
}
