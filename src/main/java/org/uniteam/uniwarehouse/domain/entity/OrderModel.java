package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.uniteam.uniwarehouse.domain.entity.base.BaseIdEntity;

import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 16 дек. 2024
 **/
@Entity(name = "order_models")
public class OrderModel extends BaseIdEntity {
    @Column(name = "model_name", length = 50)
    private String name;
    @Column(name = "model_size", length = 10)
    private String size;
    @Column(name = "model_count")
    private Integer count;
    @Column(name = "model_description", length = 2000)
    private String description;
    @ManyToOne(targetEntity = OrderModelStatus.class)
    @JoinColumn(name = "order_model_statuses_id", referencedColumnName = "id")
    private OrderModelStatus status;
    @OneToOne(targetEntity = Order.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;
    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<OrderModelAttribute> attributes;

    public OrderModel() {}

    public OrderModel(OrderModelStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderModelStatus getStatus() {
        return status;
    }

    public void setAttributes(List<OrderModelAttribute> attributes) {
        this.attributes = attributes;
    }

    public void setStatus(OrderModelStatus status) {
        this.status = status;
    }
}
