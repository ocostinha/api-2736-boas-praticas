package com.fiap.hotel_boa_pratica.service;

import com.fiap.hotel_boa_pratica.domain.Quarto;
import com.fiap.hotel_boa_pratica.mapper.QuartoMapper;
import com.fiap.hotel_boa_pratica.repository.QuartoRepository;
import com.fiap.hotel_boa_pratica.repository.entity.QuartoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    private QuartoMapper mapper = QuartoMapper.INSTANCE;


    public Optional<Quarto> findByNumeroQuarto(final String numeroQuarto) {
        Optional<QuartoEntity> quartoEntity = quartoRepository.findByNumeroQuarto(numeroQuarto);

        return quartoEntity.map(mapper::toDomain);
    }

    public Optional<Quarto> findById(final Integer id) {
        Optional<QuartoEntity> quartoEntity = quartoRepository.findById(id);

        return quartoEntity.map(mapper::toDomain);
    }

    public List<Quarto> findByStatusOrTipoAcomodacaoOrNumeroQuarto(final String status, final String tipoAcomodacao, final String numeroQuarto) {
        List<QuartoEntity> quartoEntity = quartoRepository.findByStatusOrTipoQuartoOrNumeroQuarto(
            QuartoEntity.Status.valueOf(status),
            QuartoEntity.TipoQuarto.valueOf(tipoAcomodacao),
            numeroQuarto
        );

        return mapper.toListDomain(quartoEntity);
    }

    public Quarto save(final Quarto quarto) {
        QuartoEntity quartoEntity = quartoRepository.save(mapper.toEntity(quarto));

        return mapper.toDomain(quartoEntity);
    }

    public List<Quarto> findAll() {
        List<QuartoEntity> quartoEntityList = quartoRepository.findAll();

        return mapper.toListDomain(quartoEntityList);
    }

    public Optional<Quarto> findByIdAndNumeroQuarto(final Integer id, final String numeroQuarto) {
        Optional<QuartoEntity> quartoEntity = quartoRepository.findByIdAndNumeroQuarto(id, numeroQuarto);

        return quartoEntity.map(mapper::toDomain);
    }

}
