package org.uniteam.uniwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uniteam.uniwarehouse.domain.entity.Resource;

import java.util.Optional;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 07 янв. 2025
 **/
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    Optional<Resource> findByToken(String token);
}
