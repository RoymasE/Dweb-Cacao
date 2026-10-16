package com.cacaormpresa.cacaormpresa.repository;

import com.cacaormpresa.cacaormpresa.entity.PackingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PackingListRepository extends JpaRepository<PackingList, Long> {
    Optional<PackingList> findByCodigoPackingList(String codigoPackingList);
    Optional<PackingList> findByPedidoId(Long pedidoId);
}
