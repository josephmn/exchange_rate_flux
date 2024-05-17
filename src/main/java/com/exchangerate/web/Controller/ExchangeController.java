package com.exchangerate.web.Controller;

import com.exchangerate.application.dto.ExchangeResponse;
import com.exchangerate.application.dto.ExchangeSaveResponse;
import com.exchangerate.application.dto.Request;
import com.exchangerate.application.service.ExchangeService;
import com.exchangerate.domain.model.ExchangeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @Autowired
    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

//    @GetMapping("/listexchangesave")
//    public Mono<ResponseEntity<Flux<ExchangeEntity>>> getExchangeSave() {
//        Flux<ExchangeEntity> exchangeEntities = this.exchangeService.getExchangeSave();
//        return Mono.just(ResponseEntity.ok(exchangeEntities))
//                .defaultIfEmpty(ResponseEntity.noContent().build());
//    }

    @GetMapping("/listexchangesave")
    public Flux<ExchangeEntity> getExchangeSave() {
        return this.exchangeService.getExchangeSave();
    }

    @GetMapping("/exchange")
    public Mono<ExchangeEntity> exchange(@RequestBody Request request) {
        return this.exchangeService.exchange(request);
    }
}
