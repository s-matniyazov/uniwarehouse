package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.uniteam.uniwarehouse.domain.entity.base.BaseIdEntity;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 12 Dec. 2024
 **/
@Entity(name = "in_products")
public class InProduct extends BaseIdEntity {
    private Double amount;
    @ManyToOne(optional = false, targetEntity = Product.class)
    @JoinColumn(name = "owner_products_id", referencedColumnName = "id")
    private Product ownerProduct;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    private Product product;

    public InProduct() {
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
