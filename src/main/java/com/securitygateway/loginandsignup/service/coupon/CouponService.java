package com.securitygateway.loginandsignup.service.coupon;

import com.securitygateway.loginandsignup.service.AbstractService;
import entity.Coupon;
import entity.Order;
import org.hibernate.service.spi.ServiceException;

/**
 * @author Oli-Un-Nahar Asha
 */
public interface CouponService extends AbstractService<Coupon> {

     Coupon findByCouponCode(String couponCode) throws ServiceException;

}
