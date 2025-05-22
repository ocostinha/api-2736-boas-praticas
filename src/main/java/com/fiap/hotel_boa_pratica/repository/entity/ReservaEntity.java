package com.fiap.hotel_boa_pratica.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer idHospede1;

    @Column
    private Integer idHospede2;

    @Column
    private String numeroQuarto;

    @Column
    private LocalDate dataEntrada;

    @Column
    private LocalDate dataSaida;

    @Column
    private Status status;

    public enum Status {
        CONFIRMADA, CANCELADA, EM_ANDAMENTO
    }

}
