package com.securitygateway.loginandsignup.service;

import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;

/**
 * @author Oli-Un-Nahar Asha
 */
public interface AbstractService<T> {
    T create(T t) throws ServiceException;

    T update(Long id, T t) throws ServiceException;

    Boolean delete(Long id) throws ServiceException;

    T findById(Long id) throws ServiceException;

    Page<T> findAll(int page, int size);
}
