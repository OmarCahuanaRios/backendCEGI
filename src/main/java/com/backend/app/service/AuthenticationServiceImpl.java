package com.backend.app.service;

import com.backend.app.config.JwtService;
import com.backend.app.dto.create.CreateUserDto;
import com.backend.app.dto.UserDto;
import com.backend.app.exception.EmailExistsException;
import com.backend.app.exception.EmailNotExistsException;
import com.backend.app.model.Role;
import com.backend.app.model.User;
import com.backend.app.model.auth.AuthenticationRequest;
import com.backend.app.model.auth.AuthenticationResponse;
import com.backend.app.model.auth.Token;
import com.backend.app.model.auth.TokenType;
import com.backend.app.repository.TokenRepository;
import com.backend.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public AuthenticationResponse register(CreateUserDto request, Role role) {
        User user = User.builder()
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();
        Optional<User> optionalUser = repository.findByEmail(request.getEmail());
        if (optionalUser.isPresent()) {
            throw new EmailExistsException("Email Already Exists for User");
        }
        User savedUser = repository.save(user);
        String jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(savedUser.getRole())
                .build();
    }

    @Transactional
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EmailNotExistsException("Email Not Found"));
        revokeAllUserTokens(user);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        String jwtToken = jwtService.generateToken(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(user.getRole())
                .build();
    }

    @Transactional
    public UserDto deleteUser(String email) {
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new EmailNotExistsException("Email Not Found"));
        deleteAllUserTokens(user);
        repository.delete(user);
        return UserDto.builder()
                .email(user.getEmail())
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = new Token();
        token.setUser(user);
        token.setToken(jwtToken);
        token.setTokenType(TokenType.BEARER);
        token.setExpired(false);
        token.setRevoked(false);
        tokenRepository.save(token);
    }

    private boolean revokeAllUserTokens(User user) {
        List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return false;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
        return true;
    }

    private void deleteAllUserTokens(User user) {
        List<Token> validUserTokens = tokenRepository.findAllByUser_Id(user.getId());
        System.out.println(validUserTokens.isEmpty());
        if (validUserTokens.isEmpty())
            return;
        tokenRepository.deleteAll(validUserTokens);
    }
}