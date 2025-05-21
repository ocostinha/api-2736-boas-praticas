package com.fiap.hotel_boa_pratica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hospede {

    private Integer id;

    private String nomeCompleto;

    private String documento;

    private LocalDate dataNascimento;

    private String enderecoCompleto;

    private String email;

    private String ddd;

    private String telefone;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String pais;

}
