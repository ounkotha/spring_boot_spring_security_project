package com.securitygateway.loginandsignup.repository;

import entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Oli-Un-Nahar Asha
 */
public interface OrderRepository  extends JpaRepository<Order, Long> {
}
