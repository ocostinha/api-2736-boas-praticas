package com.fiap.hotel_boa_pratica.domain;

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
public class Quarto {
    private Integer id;

    private String numeroQuarto;

    private TipoQuarto tipoQuarto;

    private Status status;

    public enum TipoQuarto {
        CASAL, SOLTEIRO, DUPLO
    }

    public enum Status {
        DISPONIVEL, OCUPADO, EM_MANUTENCAO
    }
}
