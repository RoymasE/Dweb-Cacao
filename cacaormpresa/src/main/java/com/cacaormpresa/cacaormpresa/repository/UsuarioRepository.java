package com.cacaormpresa.cacaormpresa.repository;

import com.cacaormpresa.cacaormpresa.entity.Rol;
import com.cacaormpresa.cacaormpresa.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    List<Usuario> findByRol(Rol rol);
}
