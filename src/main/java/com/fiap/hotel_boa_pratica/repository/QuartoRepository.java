package com.fiap.hotel_boa_pratica.repository;

import com.fiap.hotel_boa_pratica.repository.entity.QuartoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuartoRepository extends JpaRepository<QuartoEntity, Integer> {

    Optional<QuartoEntity> findByNumeroQuarto(String numeroQuarto);

    List<QuartoEntity> findByStatusOrTipoQuartoOrNumeroQuarto(final QuartoEntity.Status status, final QuartoEntity.TipoQuarto tipoQuarto, final String numeroQuarto);

    Optional<QuartoEntity> findByIdAndNumeroQuarto(Integer id, String numeroQuarto);

}
