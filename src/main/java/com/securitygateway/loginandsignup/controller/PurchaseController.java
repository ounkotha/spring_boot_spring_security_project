package com.securitygateway.loginandsignup.controller;

import com.securitygateway.loginandsignup.model.ApiResponse;
import com.securitygateway.loginandsignup.model.ListSearchModel;
import com.securitygateway.loginandsignup.service.ControllerAuthenticationService;
import com.securitygateway.loginandsignup.service.product.ProductService;
import com.securitygateway.loginandsignup.service.order.OrderService;
import entity.Order;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);
    final String controllerName = PurchaseController.class.getSimpleName();

    @Autowired
    OrderService purchaseService;
    @Autowired
    ProductService productService;
    @Autowired
    ControllerAuthenticationService controllerAuthenticationService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody @Valid Order order) {
        ApiResponse response = new ApiResponse(false);
        if (!controllerAuthenticationService.authoriseUserByUserIdAndFeatureController(controllerName)) {
            response.setMessage("Unauthorised.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

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
        if (!controllerAuthenticationService.authoriseUserByUserIdAndFeatureController(controllerName)) {
            response.setMessage("Unauthorised.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

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
