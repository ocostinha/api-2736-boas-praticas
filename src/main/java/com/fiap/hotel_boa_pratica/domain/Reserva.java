package com.fiap.hotel_boa_pratica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    private Integer id;

    private Integer idHospede1;

    private Integer idHospede2;

    private String numeroQuarto;

    private LocalDate dataEntrada;

    private LocalDate dataSaida;

    private Status status;

    public enum Status {
        CONFIRMADA, CANCELADA, EM_ANDAMENTO
    }

}
