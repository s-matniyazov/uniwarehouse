package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.*;
import org.uniteam.uniwarehouse.domain.entity.base.BaseNameEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 20 нояб. 2024
 **/
@Entity(name = "products")
public class Product extends BaseNameEntity {
    // for calculate price ex(1,5 * price)
    private Double amount;
    // base price
    private BigDecimal price;

    @Column(name = "tin_code", length = 100)
    private String tinCode;

    @ManyToOne(optional = false, targetEntity = Unit.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "units_id", referencedColumnName = "id")
    private Unit unit;

    @ManyToOne(optional = false, targetEntity = ProductQuality.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_qualities_id", referencedColumnName = "id")
    private ProductQuality quality;

    @ManyToOne(optional = false, targetEntity = ProductType.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_types_id", referencedColumnName = "id")
    private ProductType type;

    @ManyToOne(optional = false, targetEntity = ProductStatus.class)
    @JoinColumn(name = "product_statuses_id", referencedColumnName = "id")
    private ProductStatus status;

    // todo: productlar listi ( quramina alatin productilar ) ( typena qaray alatin qiliwam bo'liwam mumkin { shunday quramdag'i productlardi o'z quramina aladi })
    @OneToMany(targetEntity = InProduct.class, mappedBy = "ownerProduct")
    private List<InProduct> inProducts;

    public Product() {
        super();
    }

    public Product(String nameUz, String nameUk, String nameRu, String nameEn, Double amount, BigDecimal price,
                   String tinCode, Unit unit, ProductQuality quality, ProductType type, ProductStatus status) {
        super(nameUz, nameUk, nameRu, nameEn);
        this.amount = amount;
        this.price = price;
        this.tinCode = tinCode;
        this.unit = unit;
        this.quality = quality;
        this.type = type;
        this.status = status;
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

    public String getTinCode() {
        return tinCode;
    }

    public void setTinCode(String tinCode) {
        this.tinCode = tinCode;
    }

    public Unit getUnit() {
        return unit;
    }

    public List<InProduct> getInProducts() {
        return inProducts;
    }

    public void setInProducts(List<InProduct> inProducts) {
        this.inProducts = inProducts;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public ProductQuality getQuality() {
        return quality;
    }

    public void setQuality(ProductQuality quality) {
        this.quality = quality;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
}
