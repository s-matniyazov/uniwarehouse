package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import org.uniteam.uniwarehouse.domain.entity.base.BaseIdEntity;

import java.sql.Date;
import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 16 дек. 2024
 **/
@Entity(name = "orders")
public class Order extends BaseIdEntity {
    @Column(name = "customer", length = 50)
    private String customer;

    @Column(name = "order_number", length = 50)
    private String number;
    @Column(name = "order_date")
    private Date date;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "order_statuses_id", referencedColumnName = "id")
    private OrderStatus status;

    @OneToOne(mappedBy = "order")
    private OrderModel model;

    @OneToMany(mappedBy = "order")
    private List<OrderWork> works;

    public Order() {}

    public Order(Integer id, String customer, String number, java.sql.Date date, String description, OrderStatus orderStatus) {
        super(id);
        this.customer = customer;
        this.number = number;
        this.date = date;
        this.description = description;
        this.status = orderStatus;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderModel getModel() {
        return model;
    }

    public void setModel(OrderModel model) {
        this.model = model;
    }
}
