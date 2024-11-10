package com.securitygateway.loginandsignup.service;

import com.securitygateway.loginandsignup.repository.FeaturesRepository;
import entity.Features;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Oli-Un-Nahar Asha
 */
@Service
public class ControllerAuthenticationServiceImpl implements ControllerAuthenticationService{
    @Autowired
    SpringSecurityUtil springSecurityUtil;
    @Autowired
    FeaturesRepository featuresRepository;
    @Override
    public boolean authoriseUserByUserIdAndFeatureController(String controllerName) throws RuntimeException {
        Long id = springSecurityUtil.getLoggedInUserId();
        Features features = featuresRepository.getFeatureByUserIdAndControllerName(id, controllerName);
        if (features != null && features.getControllerName().equals(controllerName)) {
            return true;
        } else {
            return false;
        }
    }
}
