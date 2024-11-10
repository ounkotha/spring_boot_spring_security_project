package com.securitygateway.loginandsignup.service;

import com.securitygateway.loginandsignup.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Oli-Un-Nahar Asha
 */
@Service
public class SpringSecurityUtil {

    public Long getLoggedInUserId() {
        Long userId = null;
        try {
            User uModel = getLoggedInUser();
            userId = uModel != null ? uModel.getId() : null;
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return userId;
    }
    public User getLoggedInUser() {
        User uModel = null;
        try {
            if (SecurityContextHolder.getContext() != null &&
                    SecurityContextHolder.getContext().getAuthentication() != null &&
                    SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null &&
                    SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
                uModel = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return uModel;
    }
}
