package com.exchangerate.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ExchangeRateClient {

    private final WebClient webClient;

    @Autowired
    public ExchangeRateClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://open.er-api.com/v6/latest/").build();
    }

    public Mono<Double> getCurrency(String from, String to) {
        return webClient.get()
                .uri(from)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(jsonNode -> jsonNode.path("rates").path(to).asDouble());
    }

}
