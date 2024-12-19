package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.uniteam.uniwarehouse.domain.entity.base.BaseIdEntity;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 20 нояб. 2024
 **/
@Entity(name = "warehouses")
public class Warehouse extends BaseIdEntity {
    private String name;
    // might have a filial

    @ManyToOne(optional = false, targetEntity = ProductType.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "warehouse_product_types_id", referencedColumnName = "id")
    private ProductType type;

    public Warehouse() {
        super();
    }

    public Warehouse(String name, ProductType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
