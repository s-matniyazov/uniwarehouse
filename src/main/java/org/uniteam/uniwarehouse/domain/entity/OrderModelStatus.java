package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.Entity;
import org.uniteam.uniwarehouse.domain.entity.base.BaseNameEntity;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 16 дек. 2024
 **/
@Entity(name = "order_model_statuses")
public class OrderModelStatus extends BaseNameEntity {
    private Boolean isInitial;

    public Boolean getInitial() {
        return isInitial;
    }

    public void setInitial(Boolean initial) {
        isInitial = initial;
    }
}
