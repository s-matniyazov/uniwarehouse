package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.Entity;
import org.uniteam.uniwarehouse.domain.entity.base.BaseNameEntity;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 16 дек. 2024
 **/
@Entity(name = "order_statuses")
public class OrderStatus extends BaseNameEntity {
    private Boolean isInitial;

    public Boolean getInitial() {
        return isInitial;
    }

    public void setInitial(Boolean initial) {
        isInitial = initial;
    }
}
