package com.fiap.hotel_boa_pratica.controller;

import com.fiap.hotel_boa_pratica.business.HospedeBusiness;
import com.fiap.hotel_boa_pratica.controller.dto.HospedeDTO;
import com.fiap.hotel_boa_pratica.controller.dto.HospedeUsaDTO;
import com.fiap.hotel_boa_pratica.domain.Hospede;
import com.fiap.hotel_boa_pratica.mapper.HospedeMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    // Mesma coisa que o endpoint POST na raiz, com contrato em ingles para demonstrar
    // a funcionalidade de arquitetura em camadas
    @PostMapping("/usa")
    @ResponseStatus(HttpStatus.CREATED)
    public HospedeUsaDTO createUsa(@RequestBody @Valid HospedeUsaDTO dto) {
        Hospede hospedeCadastrado = hospedeBusiness.create(mapper.toDomain(dto));

        return mapper.toUsaDTO(hospedeCadastrado);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public HospedeDTO update(@RequestBody @Valid HospedeDTO dto) {
        Hospede hospedeAtualizado = hospedeBusiness.update(mapper.toDomain(dto));

        return mapper.toDTO(hospedeAtualizado);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HospedeDTO> findAll() {
        List<Hospede> hospedes = hospedeBusiness.findAll();

        return mapper.toDTOList(hospedes);
    }

    @GetMapping("/filtro")
    @ResponseStatus(HttpStatus.OK)
    public List<HospedeDTO> findByNomeOrEmailOrDocumento(@RequestParam("nome") String nome,
                                                         @RequestParam("documento") String documento,
                                                         @RequestParam("email") String email) {
        List<Hospede> hospedes = hospedeBusiness.findByNomeOrEmailOrDocumento(nome, email, documento);

        return mapper.toDTOList(hospedes);
    }
}
