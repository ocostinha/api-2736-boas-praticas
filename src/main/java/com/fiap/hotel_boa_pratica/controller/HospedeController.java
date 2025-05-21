package com.fiap.hotel_boa_pratica.controller;

import com.fiap.hotel_boa_pratica.business.HospedeBusiness;
import com.fiap.hotel_boa_pratica.controller.dto.HospedeDTO;
import com.fiap.hotel_boa_pratica.controller.dto.HospedeUsaDTO;
import com.fiap.hotel_boa_pratica.domain.Hospede;
import com.fiap.hotel_boa_pratica.mapper.HospedeMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospede")
public class HospedeController {

    @Autowired
    private HospedeBusiness hospedeBusiness;

    private HospedeMapper mapper = HospedeMapper.INSTANCE;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HospedeDTO create(@RequestBody @Valid HospedeDTO dto) {
        Hospede hospedeCadastrado = hospedeBusiness.create(mapper.toDomain(dto));

        return mapper.toDTO(hospedeCadastrado);
    }

    @PostMapping("/usa")
    @ResponseStatus(HttpStatus.CREATED)
    public HospedeUsaDTO createUsa(@RequestBody @Valid HospedeUsaDTO dto) {
        Hospede hospedeCadastrado = hospedeBusiness.create(mapper.toDomain(dto));

        return mapper.toUsaDTO(hospedeCadastrado);
    }

}
