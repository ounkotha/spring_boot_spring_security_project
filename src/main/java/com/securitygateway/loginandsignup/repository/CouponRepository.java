package com.securitygateway.loginandsignup.repository;

import entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Oli-Un-Nahar Asha
 */
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    Coupon findByCouponCode(String couponCode);
}
