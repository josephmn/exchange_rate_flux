package com.exchangerate.application.dto;

import lombok.Data;

@Data
public class Request {
    private double amount;
    private String fromCurrency;
    private String toCurrency;
}
