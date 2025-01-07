package org.uniteam.uniwarehouse.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniteam.uniwarehouse.data.dto.OrderDTO;
import org.uniteam.uniwarehouse.data.dto.OrderModelDTO;
import org.uniteam.uniwarehouse.data.dto.OrderWorkDTO;
import org.uniteam.uniwarehouse.domain.entity.Order;
import org.uniteam.uniwarehouse.domain.entity.OrderModel;
import org.uniteam.uniwarehouse.domain.entity.OrderModelAttribute;
import org.uniteam.uniwarehouse.domain.entity.OrderWork;
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
    private final OrderWorkRepository workRepository;
    private final OrderWorkStatusRepository orderWorkStatusRepository;

    @Autowired
    public OrderService(OrderRepository repository, OrderStatusRepository statusRepository, ProductRepository productRepository, OrderModelRepository modelRepository, OrderModelStatusRepository modelStatusRepository, OrderWorkRepository workRepository, OrderWorkStatusRepository orderWorkStatusRepository) {
        this.repository = repository;
        this.statusRepository = statusRepository;
        this.productRepository = productRepository;
        this.modelRepository = modelRepository;
        this.modelStatusRepository = modelStatusRepository;
        this.workRepository = workRepository;
        this.orderWorkStatusRepository = orderWorkStatusRepository;
    }

    public List<Order> get() {
        return repository.findAll();
    }

    @Transactional
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

    @Transactional
    public OrderModel modelSave(OrderModelDTO data) {
        OrderModel model;
        if (data.id() != null)
            model = modelRepository.findById(data.id()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("order.model.not_found")));
        else
            model = new OrderModel(modelStatusRepository.findByIsInitial(true).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("order.model.status.not_found"))));

        model.setName(data.name());
        model.setSize(data.size());
        model.setCount(data.count());
        model.setDescription(data.description());
        model.setOrder(repository.findById(data.orderId()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("order.not_found"))));
        model.setAttributes(
                data.attributes().stream().map(it ->
                        new OrderModelAttribute(
                                it.id(),
                                it.amount(),
                                productRepository.findById(it.productsId()).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("product.not_found")))
                        )
                ).toList());

        return modelRepository.save(model);
    }

    @Transactional
    public List<OrderWork> workSave(Integer orderId, List<OrderWorkDTO> data) {
        Order order = repository.findById(orderId).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("order.not_found")));
        List<OrderWork> works = data.stream().map(it -> new OrderWork(
                it.name(),
                it.count(),
                order,
                orderWorkStatusRepository.findByIsInitial(true).orElseThrow(() -> new NotFoundException(mSourceBundle.apply("order.work.status.not_found")))
        )).toList();
        return workRepository.saveAll(works);
    }
}
