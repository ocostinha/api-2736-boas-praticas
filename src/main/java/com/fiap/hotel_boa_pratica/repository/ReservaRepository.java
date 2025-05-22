package com.fiap.hotel_boa_pratica.repository;

import com.fiap.hotel_boa_pratica.repository.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer> {

    List<ReservaEntity> findByDataEntradaOrDataSaidaOrStatus(LocalDate dataEntrada, LocalDate dataSaida, ReservaEntity.Status status);

}
