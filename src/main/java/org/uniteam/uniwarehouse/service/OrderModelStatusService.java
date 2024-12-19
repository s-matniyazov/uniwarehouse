package org.uniteam.uniwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniteam.uniwarehouse.domain.entity.OrderModelStatus;
import org.uniteam.uniwarehouse.repository.OrderModelStatusRepository;
import org.uniteam.uniwarehouse.service.base.BaseService;

import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 19 дек. 2024
 **/
@Service
public class OrderModelStatusService extends BaseService {
    private final OrderModelStatusRepository repository;

    @Autowired
    public OrderModelStatusService(OrderModelStatusRepository repository) {
        this.repository = repository;
    }

    public List<OrderModelStatus> get() {
        return repository.findAll();
    }

    public OrderModelStatus save(OrderModelStatus data) {
        return repository.save(data);
    }
}