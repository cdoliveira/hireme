package com.cdsoftware.hireme.controller;

import com.cdsoftware.hireme.auth.AuthenticationRequest;
import com.cdsoftware.hireme.auth.AuthenticationResponse;
import com.cdsoftware.hireme.auth.AuthenticationService;
import com.cdsoftware.hireme.auth.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid RegisterRequest registerRequest){
        return ResponseEntity.ok(service.register(registerRequest));
    }

    /*@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequest registerRequest){
        return ResponseEntity.ok("Valid");
        *//*return ResponseEntity.ok(service.register(registerRequest));*//*
    }*/

    @PostMapping("/register-worker")
    public ResponseEntity<AuthenticationResponse> registerWorker(@RequestBody @Valid RegisterRequest registerRequest){
        return ResponseEntity.ok(service.registerWorker(registerRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.refreshToken(request, response);
    }

}
