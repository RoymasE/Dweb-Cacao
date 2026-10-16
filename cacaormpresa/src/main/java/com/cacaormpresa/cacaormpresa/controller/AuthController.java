package com.cacaormpresa.cacaormpresa.controller;

import com.cacaormpresa.cacaormpresa.dto.AuthDto;
import com.cacaormpresa.cacaormpresa.entity.Usuario;
import com.cacaormpresa.cacaormpresa.service.AuthService;
import com.cacaormpresa.cacaormpresa.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "1. Autenticación y Control de Acceso (RF-01)", description = "Endpoints de login seguro con BCrypt y token JWT")
public class AuthController {

    private final AuthService authService;
    private final UsuarioService usuarioService;

    public AuthController(AuthService authService, UsuarioService usuarioService) {
        this.authService = authService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    @Operation(summary = "Iniciar sesión", description = "Autentica con usuario y contraseña, devuelve token JWT y rol")
    public ResponseEntity<AuthDto.AuthResponse> login(@Valid @RequestBody AuthDto.LoginRequest request) {
        AuthDto.AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    @Operation(summary = "Registrar nuevo usuario", description = "Crea una nueva cuenta de usuario con contraseña cifrada")
    public ResponseEntity<Usuario> register(@Valid @RequestBody AuthDto.RegisterRequest request) {
        Usuario usuario = authService.register(request);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping("/me")
    @Operation(summary = "Obtener perfil autenticado", description = "Devuelve los datos del usuario actualmente autenticado mediante el token JWT")
    public ResponseEntity<Usuario> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioService.obtenerPorUsername(authentication.getName());
        return ResponseEntity.ok(usuario);
    }
}
