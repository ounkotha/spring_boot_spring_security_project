package com.securitygateway.loginandsignup.service.product;

import com.securitygateway.loginandsignup.service.AbstractService;
import entity.Order;
import entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Oli-Un-Nahar Asha
 */
public interface ProductService extends AbstractService<Product> {

    Page<Product> getPaginatedProductList(Pageable paging);
}
