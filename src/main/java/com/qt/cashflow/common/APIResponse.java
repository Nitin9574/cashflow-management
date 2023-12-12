package com.qt.cashflow.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class APIResponse {

    private Integer status;
    private Object data;
    private Object error;
    private String message;
}