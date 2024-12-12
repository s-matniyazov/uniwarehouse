package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.Entity;
import org.uniteam.uniwarehouse.domain.entity.base.BaseIconEntity;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 20 нояб. 2024
 **/
@Entity(name = "product_statuses")
public class ProductStatus extends BaseIconEntity {
    private Boolean isInitial;

    public Boolean getInitial() {
        return isInitial;
    }

    public void setInitial(Boolean initial) {
        isInitial = initial;
    }
}
