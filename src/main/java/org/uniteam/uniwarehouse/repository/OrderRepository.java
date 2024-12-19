package org.uniteam.uniwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uniteam.uniwarehouse.domain.entity.Order;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 18 дек. 2024
 **/
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
