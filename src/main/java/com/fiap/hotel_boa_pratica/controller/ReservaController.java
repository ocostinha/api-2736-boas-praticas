package com.fiap.hotel_boa_pratica.controller;

import com.fiap.hotel_boa_pratica.business.ReservaBusiness;
import com.fiap.hotel_boa_pratica.controller.dto.ReservaDTO;
import com.fiap.hotel_boa_pratica.domain.Reserva;
import com.fiap.hotel_boa_pratica.mapper.ReservaMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaBusiness reservaBusiness;

    private ReservaMapper mapper = ReservaMapper.INSTANCE;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservaDTO cadastrar(@RequestBody @Valid ReservaDTO dto) {
        Reserva reservaRealizada = reservaBusiness.cadastrarReserva(mapper.toDomain(dto));

        return mapper.toDTO(reservaRealizada);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ReservaDTO alterar(@RequestBody @Valid ReservaDTO dto) {
        Reserva reservaRealizada = reservaBusiness.alterarReserva(mapper.toDomain(dto));

        return mapper.toDTO(reservaRealizada);
    }

    @PatchMapping("/inciar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReservaDTO iniciarReserva(@PathVariable("id") Integer id) {
        Reserva reservaConfirmada = reservaBusiness.iniciarReserva(id);

        return mapper.toDTO(reservaConfirmada);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReservaDTO buscarPorId(@PathVariable("id") Integer id) {
        Reserva reserva = reservaBusiness.buscarPorId(id);

        return mapper.toDTO(reserva);
    }

    @GetMapping("/filtro")
    @ResponseStatus(HttpStatus.OK)
    public List<ReservaDTO> buscarPorDataEntradaOuDataSaidaOuStatus(
        @RequestParam("data_entrada") LocalDate dataEntrada,
        @RequestParam("data_saida") LocalDate dataSaida,
        @RequestParam("status") String status
    ) {
        List<Reserva> reservas = reservaBusiness.buscarPorDataEntradaOuDataSaidaOuStatus(
            dataEntrada,
            dataSaida,
            status
        );

        return mapper.toDTO(reservas);
    }

}
