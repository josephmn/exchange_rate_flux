package com.exchangerate.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class JwtRs {

    private String token;
    private String type = "Bearer";
    private LocalDateTime dateTime = LocalDateTime.now();

    public JwtRs(String token, String type) {
        this.token = token;
        this.type = type;
    }
}
