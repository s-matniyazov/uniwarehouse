package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.uniteam.uniwarehouse.domain.entity.base.BaseIdEntity;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 16 дек. 2024
 **/
@Entity(name = "order_works")
public class OrderWork extends BaseIdEntity {
    @Column(name = "work_name", length = 200)
    private String name;
    @Column(name = "work_count")
    private Integer count;
    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;
    @ManyToOne(targetEntity = OrderWorkStatus.class)
    @JoinColumn(name = "order_work_statuses_id", referencedColumnName = "id")
    private OrderWorkStatus status;

    public OrderWork() {
    }

    public OrderWork(String name, Integer count, Order order, OrderWorkStatus orderWorkStatus) {
        this.name = name;
        this.count = count;
        this.order = order;
        this.status = orderWorkStatus;
    }
}
