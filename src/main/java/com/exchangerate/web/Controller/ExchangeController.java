package com.exchangerate.web.Controller;

import com.exchangerate.application.dto.ExchangeResponse;
import com.exchangerate.application.dto.ExchangeSaveResponse;
import com.exchangerate.application.dto.Request;
import com.exchangerate.application.service.ExchangeService;
import com.exchangerate.domain.model.ExchangeEntity;
import com.exchangerate.util.JwtUtils;
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
    private final JwtUtils jwtUtils;

    @Autowired
    public ExchangeController(ExchangeService exchangeService, JwtUtils jwtUtils) {
        this.exchangeService = exchangeService;
        this.jwtUtils = jwtUtils;
    }

    @GetMapping("/listexchangesave")
    public Flux<ExchangeEntity> getExchangeSave(@RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        if (jwtUtils.validateJwtToken(token)) {
            return this.exchangeService.getExchangeSave();
        } else {
            return Flux.empty();
        }
    }

    @GetMapping("/exchange")
    public Mono<ExchangeEntity> exchange(@RequestHeader("Authorization") String token, @RequestBody Request request) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        if (jwtUtils.validateJwtToken(token)) {
            return this.exchangeService.exchange(request);
        } else {
            return Mono.empty();
        }
    }
}
