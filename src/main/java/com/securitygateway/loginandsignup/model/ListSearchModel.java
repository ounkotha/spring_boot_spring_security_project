package com.securitygateway.loginandsignup.model;

import lombok.Data;

/**
 * @author Oli-Un-Nahar Asha
 */
@Data
public class ListSearchModel {
    private int page;
    private int size;
    private String fromDate;
    private String toDate;
    private String orderBy;
}
