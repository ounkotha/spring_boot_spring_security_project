package com.securitygateway.loginandsignup.service;

/**
 * @author Oli-Un-Nahar Asha
 */
public interface ControllerAuthenticationService {
    boolean authoriseUserByUserIdAndFeatureController(String controllerName) throws RuntimeException;
}
