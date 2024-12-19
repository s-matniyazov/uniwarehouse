package org.uniteam.uniwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniteam.uniwarehouse.domain.entity.OrderStatus;
import org.uniteam.uniwarehouse.repository.OrderStatusRepository;
import org.uniteam.uniwarehouse.service.base.BaseService;

import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 19 дек. 2024
 **/
@Service
public class OrderStatusService extends BaseService {
    private final OrderStatusRepository repository;

    @Autowired
    public OrderStatusService(OrderStatusRepository repository) {
        this.repository = repository;
    }

    public List<OrderStatus> get() {
        return repository.findAll();
    }

    public OrderStatus save(OrderStatus data) {
        return repository.save(data);
    }
}