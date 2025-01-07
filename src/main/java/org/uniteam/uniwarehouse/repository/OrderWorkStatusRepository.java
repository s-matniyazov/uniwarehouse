package org.uniteam.uniwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uniteam.uniwarehouse.domain.entity.OrderWorkStatus;

import java.util.Optional;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 07 янв. 2025
 **/
public interface OrderWorkStatusRepository extends JpaRepository<OrderWorkStatus, Integer> {
    Optional<OrderWorkStatus> findByIsInitial(Boolean isInitial);
}
