package com.fiap.hotel_boa_pratica.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuartoDTO {
    private Integer id;

    @NotEmpty
    private String numeroQuarto;

    @NotNull
    private TipoQuarto tipoQuarto;

    @NotNull
    private Status status;

    public enum TipoQuarto {
        CASAL, SOLTEIRO, DUPLO
    }

    public enum Status {
        DISPONIVEL, OCUPADO, EM_MANUTENCAO
    }
}
