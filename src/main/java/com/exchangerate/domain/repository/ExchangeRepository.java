package com.exchangerate.domain.repository;

import com.exchangerate.domain.model.ExchangeEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends ReactiveCrudRepository<ExchangeEntity, Long> {
}
