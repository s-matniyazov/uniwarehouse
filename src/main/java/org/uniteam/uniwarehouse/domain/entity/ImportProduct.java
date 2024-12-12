package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.uniteam.uniwarehouse.domain.entity.base.BaseIdEntity;

import java.math.BigDecimal;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 28 нояб. 2024
 **/
@Entity(name = "import_products")
public class ImportProduct extends BaseIdEntity {
    private Double amount;
    private BigDecimal price;
    @ManyToOne(optional = false, targetEntity = Product.class)
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Import.class)
    @JoinColumn(name = "imports_id", referencedColumnName = "id")
    private Import importP;

    public ImportProduct() {
    }

    public ImportProduct(Double amount, BigDecimal price, Product product, Import importP) {
        this.amount = amount;
        this.price = price;
        this.product = product;
        this.importP = importP;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
