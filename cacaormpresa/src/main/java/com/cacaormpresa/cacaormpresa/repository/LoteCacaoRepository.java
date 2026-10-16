package com.cacaormpresa.cacaormpresa.repository;

import com.cacaormpresa.cacaormpresa.entity.LoteCacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoteCacaoRepository extends JpaRepository<LoteCacao, Long> {
    Optional<LoteCacao> findByCodigoLote(String codigoLote);
    List<LoteCacao> findByEstado(LoteCacao.EstadoLote estado);
    List<LoteCacao> findByProveedorId(Long proveedorId);

    @Query("SELECT COALESCE(SUM(l.pesoBabaKg), 0.0) FROM LoteCacao l")
    Double sumTotalPesoCosechadoKg();
}
