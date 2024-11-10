package com.securitygateway.loginandsignup.service.order;

import com.securitygateway.loginandsignup.repository.OrderRepository;
import com.securitygateway.loginandsignup.service.coupon.CouponService;
import entity.Coupon;
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
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CouponService couponService;
    @Override
    public Order create(Order order) throws ServiceException {

        Coupon coupon = couponService.findByCouponCode(order.getCouponCode());
        if(order.getCountForProduct() > order.getProduct().getAvailableStock()){
            throw new RuntimeException("Insufficient Product.");
        }
        if(order.getCouponCode()!=null && coupon != null){
           if(coupon.getEndDate().after(Calendar.getInstance().getTime())){
               throw new RuntimeException("Coupon Date Expired.");
           }
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
