package com.fiap.hotel_boa_pratica.controller;

import com.fiap.hotel_boa_pratica.business.QuartoBusiness;
import com.fiap.hotel_boa_pratica.controller.dto.QuartoDTO;
import com.fiap.hotel_boa_pratica.domain.Quarto;
import com.fiap.hotel_boa_pratica.mapper.QuartoMapper;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
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
@RequestMapping
public class QuartoController {

    @Autowired
    private QuartoBusiness quartoBusiness;

    private QuartoMapper mapper = QuartoMapper.INSTANCE;

    @PostMapping("/quarto")
    @ResponseStatus(HttpStatus.CREATED)
    public QuartoDTO create(@RequestBody @Valid QuartoDTO dto) {
        Quarto quarto = quartoBusiness.create(mapper.toDomain(dto));

        return mapper.toDTO(quarto);
    }

    @PutMapping("/quarto")
    @ResponseStatus(HttpStatus.OK)
    public QuartoDTO update(@RequestBody @Valid QuartoDTO dto) {
        Quarto quarto = quartoBusiness.update(mapper.toDomain(dto));

        return mapper.toDTO(quarto);
    }

    @GetMapping("/quarto")
    @ResponseStatus(HttpStatus.OK)
    public List<QuartoDTO> findAll() {
        List<Quarto> quartoList = quartoBusiness.findAll();

        return mapper.toListDTO(quartoList);
    }

    @GetMapping("/quarto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public QuartoDTO findById(@PathParam("id") Integer id) {
        Quarto quarto = quartoBusiness.findById(id);

        return mapper.toDTO(quarto);
    }

    @GetMapping("/quarto/filtro")
    @ResponseStatus(HttpStatus.OK)
    public List<QuartoDTO> findByStatusOrTipoAcomodacaoOrNumeroQuarto(@Nullable @RequestParam("numero_quarto") String numeroQuarto,
                                                                      @Nullable @RequestParam("tipo_acomodacao") String tipoAcomodacao,
                                                                      @Nullable @RequestParam("status") String status) {
        List<Quarto> quartoList = quartoBusiness.findByStatusOrTipoAcomodacaoOrNumeroQuarto(status, tipoAcomodacao, numeroQuarto);

        return mapper.toListDTO(quartoList);
    }

}
