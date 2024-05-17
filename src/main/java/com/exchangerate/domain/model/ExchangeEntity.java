package com.exchangerate.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table(name = "exchange")
public class ExchangeEntity {
    @Id
    private Long id;

    @Column(value = "amount")
    private double amount;

    @Column(value = "from_currency")
    private String fromCurrency;

    @Column(value = "to_currency")
    private String toCurrency;

    @Column(value = "exchange_rate")
    private double exchangeRate;

    @Column(value = "converted_amount")
    private double convertedAmount;

    @Column(value = "local_date_time")
    private LocalDateTime localDateTime = LocalDateTime.now();
}
