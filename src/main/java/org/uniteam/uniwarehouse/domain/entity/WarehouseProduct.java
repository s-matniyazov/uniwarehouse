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
@Entity(name = "warehouse_products")
public class WarehouseProduct extends BaseIdEntity {
    private Double amount;
    @ManyToOne(optional = false, targetEntity = Product.class)
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Warehouse.class, optional = false)
    @JoinColumn(name = "warehouses_id", referencedColumnName = "id")
    private Warehouse warehouse;

    public WarehouseProduct() {
    }

    public WarehouseProduct(Double amount, Product product, Warehouse warehouse) {
        this.amount = amount;
        this.product = product;
        this.warehouse = warehouse;
    }

    public Double getAmount() {
        return amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
