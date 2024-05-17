CREATE TABLE exchange (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    amount DECIMAL(19, 6),
    from_currency VARCHAR(255),
    to_currency VARCHAR(255),
    exchange_rate DECIMAL(19, 6),
    converted_amount DECIMAL(19, 6),
    local_date_time TIMESTAMP
);