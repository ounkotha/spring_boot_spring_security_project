package com.securitygateway.loginandsignup.repository;

import com.securitygateway.loginandsignup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/**
 * @author Oli-Un-Nahar Asha
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByEmail(String email);
}
