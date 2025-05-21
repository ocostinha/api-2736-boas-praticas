package com.fiap.hotel_boa_pratica.repository;

import com.fiap.hotel_boa_pratica.repository.entity.HospedeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospedeRepository extends JpaRepository<HospedeEntity, Integer> {

    List<HospedeEntity> findByNomeCompletoOrEmailOrDocumento(String nome, String email, String documento);

}
