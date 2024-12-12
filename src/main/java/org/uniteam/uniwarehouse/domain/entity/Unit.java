package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.uniteam.uniwarehouse.domain.entity.base.BaseIconEntity;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 20 нояб. 2024
 **/
@Entity(name = "units")
public class Unit extends BaseIconEntity {
    @Column(name = "code", length = 20)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
