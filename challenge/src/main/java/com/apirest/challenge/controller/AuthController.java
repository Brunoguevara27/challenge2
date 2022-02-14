package com.apirest.challenge.controller;

import com.apirest.challenge.dto.LoginDto;
import com.apirest.challenge.segurity.JwtAuthResponseDto;
import com.apirest.challenge.segurity.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("")
    public ResponseEntity<JwtAuthResponseDto> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsuario(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //Obtenemos el token del jwtTokenProvider
        String token = jwtTokenProvider.generarToken(authentication);
        return ResponseEntity.ok(new JwtAuthResponseDto(token));
    }
}
