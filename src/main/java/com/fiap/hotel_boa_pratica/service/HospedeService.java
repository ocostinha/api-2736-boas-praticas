package com.fiap.hotel_boa_pratica.service;

import com.fiap.hotel_boa_pratica.domain.Hospede;
import com.fiap.hotel_boa_pratica.mapper.HospedeMapper;
import com.fiap.hotel_boa_pratica.repository.HospedeRepository;
import com.fiap.hotel_boa_pratica.repository.entity.HospedeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository repository;

    private HospedeMapper mapper = HospedeMapper.INSTANCE;

    public Hospede salvar(Hospede hospede) {
        HospedeEntity entity = repository.save(mapper.toEntity(hospede));

        return mapper.toDomain(entity);
    }

    public List<Hospede> findAll() {
        List<HospedeEntity> hospedes = repository.findAll();

        return mapper.toDomainList(hospedes);
    }

    public List<Hospede> findByNomeOrEmailOrDocumento(String nome, String email, String documento) {
        List<HospedeEntity> hospedes = repository.findByNomeCompletoOrEmailOrDocumento(nome, email, documento);

        return mapper.toDomainList(hospedes);
    }

}
