package com.securitygateway.loginandsignup.service.product;

import com.securitygateway.loginandsignup.repository.ProductRepository;
import entity.Product;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Oli-Un-Nahar Asha
 */
@Service
public class ProdcutServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product create(Product product) throws ServiceException {
        return null;
    }

    @Override
    public Product update(Long id, Product product) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Product findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<Product> findAll(int page, int size) {
        return null;
    }

    @Override
    public Page<Product> getPaginatedProductList(Pageable paging) {
        return productRepository.findAllPaginatedProductList(paging);
    }
}
