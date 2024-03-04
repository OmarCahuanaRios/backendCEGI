package com.backend.app.controller;

import com.backend.app.dto.create.CreateUserDto;
import com.backend.app.dto.UserDto;
import com.backend.app.model.Role;
import com.backend.app.model.auth.AuthenticationRequest;
import com.backend.app.model.auth.AuthenticationResponse;
import com.backend.app.service.impl.AuthenticationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationServiceImpl service;

    public AuthenticationController(AuthenticationServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/register/role/{role}")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid CreateUserDto request, @PathVariable Role role) {
        return ResponseEntity.ok(service.register(request, role));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody @Valid AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @DeleteMapping("/delete/{email}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto> delete(@PathVariable String email) {
        return ResponseEntity.ok(service.deleteUser(email));
    }
}
