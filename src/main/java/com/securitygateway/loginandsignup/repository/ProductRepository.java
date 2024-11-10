package com.securitygateway.loginandsignup.repository;

import entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Oli-Un-Nahar Asha
 */
public interface ProductRepository  extends JpaRepository<Product, Long> {

    Page<Product> findAllPaginatedProductList(Pageable pageable);
}
