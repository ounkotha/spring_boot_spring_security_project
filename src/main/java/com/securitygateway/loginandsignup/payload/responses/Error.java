package com.securitygateway.loginandsignup.payload.responses;

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
public class Error {
    private String errorCode;
    private String errorMessage;
    private String additionalInfo;
}