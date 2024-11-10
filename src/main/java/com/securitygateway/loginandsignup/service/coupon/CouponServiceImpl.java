package com.securitygateway.loginandsignup.service.coupon;

import com.securitygateway.loginandsignup.repository.CouponRepository;
import entity.Coupon;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author Oli-Un-Nahar Asha
 */
@Service
public class CouponServiceImpl implements CouponService{

    @Autowired
    CouponRepository couponRepository;
    @Override
    public Coupon create(Coupon coupon) throws ServiceException {
        return null;
    }

    @Override
    public Coupon update(Long id, Coupon coupon) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Coupon findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<Coupon> findAll(int page, int size) {
        return null;
    }

    @Override
    public Coupon findByCouponCode(String couponCode) throws ServiceException {
        Coupon coupon = couponRepository.findByCouponCode(couponCode);
        if (coupon == null) {
            throw new ServiceException("Coupon not found.");
        }
        return coupon;
    }
}
