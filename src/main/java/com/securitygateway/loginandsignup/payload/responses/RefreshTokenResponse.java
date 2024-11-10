package com.securitygateway.loginandsignup.payload.responses;

import com.securitygateway.loginandsignup.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Oli-Un-Nahar Asha
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshTokenResponse {
    private String accessToken;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
