package com.securitygateway.loginandsignup.controller;

import com.securitygateway.loginandsignup.model.ApiResponse;
import com.securitygateway.loginandsignup.model.ListSearchModel;
import com.securitygateway.loginandsignup.service.product.ProductService;
import com.securitygateway.loginandsignup.service.purchase.PurchaseService;
import entity.Order;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Oli-Un-Nahar Asha
 */

@RequestMapping("/api/purchase")
@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody @Valid Order order) {
        ApiResponse response = new ApiResponse(false);

        try {
            response.setData(purchaseService.create(order));
            response.setSuccess(true);
            response.setMessage("Data Saved Successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error(e.getMessage());
            response.setMessage(e.getMessage());
            response.setSuccess(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

    }

    @RequestMapping(value = "/productList", method = RequestMethod.POST)
    public ResponseEntity<Object> getProductList(@RequestBody ListSearchModel searchModel) {
        ApiResponse response = new ApiResponse(false);

        try {
            response.setData(productService.getPaginatedProductList(PageRequest.of(searchModel.getPage() - 1, searchModel.getSize(), Sort.by(Sort.Direction.DESC, searchModel.getOrderBy()))));
            ;
            response.setMessage("Product List is loaded Successfully");
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
