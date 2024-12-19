package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.uniteam.uniwarehouse.domain.entity.base.BaseIdEntity;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 16 дек. 2024
 **/
@Entity(name = "order_model_attributes")
public class OrderModelAttribute extends BaseIdEntity {
    private Double amount;
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    private Product product;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(targetEntity = OrderModel.class)
    @JoinColumn(name = "order_models_id", referencedColumnName = "id")
    private OrderModel model;

    public OrderModelAttribute() {}

    public OrderModelAttribute(Integer id, Double amount, Product product) {
        super(id);
        this.amount = amount;
        this.product = product;
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
