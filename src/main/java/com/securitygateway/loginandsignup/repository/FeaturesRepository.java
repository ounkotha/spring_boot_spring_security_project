package com.securitygateway.loginandsignup.repository;

import entity.Features;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Oli-Un-Nahar Asha
 */

public interface FeaturesRepository extends JpaRepository<Features,Long> {

    Features findByIdAndControllerName(Long id, String controllerName);;
}
