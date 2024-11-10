package com.securitygateway.loginandsignup.service.purchase;

import com.securitygateway.loginandsignup.repository.OrderRepository;
import entity.Order;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * @author Oli-Un-Nahar Asha
 */
@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    OrderRepository orderRepository;
    @Override
    public Order create(Order order) throws ServiceException {

        if(order.getCountForProduct() > order.getProduct().getAvailableStock()){
            throw new RuntimeException("Insufficient Product.");
        }
        order.setCreatedAt(Calendar.getInstance());
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, Order order) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Order findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<Order> findAll(int page, int size) {
        return null;
    }
}
