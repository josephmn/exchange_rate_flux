package com.exchangerate.application.service;

import com.exchangerate.application.dto.Request;
import com.exchangerate.domain.model.ExchangeEntity;
import com.exchangerate.domain.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ExchangeService {

    private final ExchangeRateClient exchangeRateClient;
    private final ExchangeRepository exchangeRepository;

    @Autowired
    public ExchangeService(ExchangeRateClient exchangeRateClient, ExchangeRepository exchangeRepository) {
        this.exchangeRateClient = exchangeRateClient;
        this.exchangeRepository = exchangeRepository;
    }

    public Flux<ExchangeEntity> getExchangeSave() {
        return this.exchangeRepository.findAll();
    }

    public Mono<ExchangeEntity> exchange(Request request) {
        return this.exchangeRateClient.getCurrency(request.getFromCurrency(), request.getToCurrency())
                .flatMap(rate -> {
                    double convertedAmount = request.getAmount() * rate;
                    ExchangeEntity exchangeRate = new ExchangeEntity();
                    exchangeRate.setAmount(request.getAmount());
                    exchangeRate.setFromCurrency(request.getFromCurrency());
                    exchangeRate.setToCurrency(request.getToCurrency());
                    exchangeRate.setExchangeRate(rate);
                    exchangeRate.setConvertedAmount(convertedAmount);
                    return this.exchangeRepository.save(exchangeRate);
                });
    }
}
