package org.uniteam.uniwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniteam.uniwarehouse.data.dto.OrderDTO;
import org.uniteam.uniwarehouse.data.dto.OrderModelDTO;
import org.uniteam.uniwarehouse.domain.entity.Order;
import org.uniteam.uniwarehouse.domain.entity.OrderModel;
import org.uniteam.uniwarehouse.domain.entity.OrderModelAttribute;
import org.uniteam.uniwarehouse.repository.*;
import org.uniteam.uniwarehouse.service.base.BaseService;
import org.uniteam.uniwarehouse.util.exceptions.NotFoundException;

import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 18 дек. 2024
 **/
@Service
public class OrderService extends BaseService {
    private final OrderRepository repository;
    private final OrderStatusRepository statusRepository;
    private final ProductRepository productRepository;
    private final OrderModelRepository modelRepository;
    private final OrderModelStatusRepository modelStatusRepository;

    @Autowired
    public OrderService(OrderRepository repository, OrderStatusRepository statusRepository, ProductRepository productRepository, OrderModelRepository modelRepository, OrderModelStatusRepository modelStatusRepository) {
        this.repository = repository;
        this.statusRepository = statusRepository;
        this.productRepository = productRepository;
        this.modelRepository = modelRepository;
        this.modelStatusRepository = modelStatusRepository;
    }

    public List<Order> get() {
        return repository.findAll();
    }

    public Order save(OrderDTO data) {
        return repository.save(
                new Order(
                        data.id(),
                        data.customer(),
                        data.number(),
                        data.date(),
                        data.description(),
                        statusRepository.findByIsInitial(true).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("order.status.not_found")))
                )
        );
    }

    public OrderModel modelSave(OrderModelDTO data) {
        OrderModel model;
        if (data.id() != null)
            model = modelRepository.findById(data.id()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("order.model.not_found")));
        else model = new OrderModel(modelStatusRepository.findByIsInitial(true).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("order.model.status.not_found"))));

        model.setName(data.name());
        model.setSize(data.size());
        model.setCount(data.count());
        model.setDescription(data.description());
        model.setOrder(repository.findById(data.orderId()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("order.not_found"))));
        model.setAttributes(data.attributes().stream().map(it ->
                new OrderModelAttribute(
                        it.id(),
                        it.amount(),
                        productRepository.findById(it.productsId()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("product.not_found")))
                )
        ).toList());

        return modelRepository.save(model);
    }
}
