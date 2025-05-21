package com.fiap.hotel_boa_pratica.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HospedeDTO {

    private Integer id;

    @NotEmpty
    private String nomeCompleto;

    @NotEmpty
    private String documento;

    @NotNull
    private LocalDate dataNascimento;

    private String enderecoCompleto;

    @NotEmpty
    private String email;

    private String ddd;

    private String telefone;

    private String pais;

}
