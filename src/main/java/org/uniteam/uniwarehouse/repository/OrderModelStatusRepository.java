package org.uniteam.uniwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uniteam.uniwarehouse.domain.entity.OrderModelStatus;

import java.util.Optional;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 19 дек. 2024
 **/
public interface OrderModelStatusRepository extends JpaRepository<OrderModelStatus, Integer> {
    Optional<OrderModelStatus> findByIsInitial(Boolean isInitial);
}
