package com.exchangerate.web.Controller;

import com.exchangerate.application.dto.JwtRs;
import com.exchangerate.application.dto.LoginRequest;
import com.exchangerate.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/user")
public class AuthController {

    private final JwtUtils jwtUtils;

    @Autowired
    public AuthController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signIn")
    public ResponseEntity<JwtRs> authenticateUser(@RequestBody LoginRequest loginRequest) {

        String jwt = jwtUtils.generateTokenFromUsername(loginRequest.getUsername());
        return ResponseEntity.ok(new JwtRs(
                jwt,
                "Bearer"));
    }
}
