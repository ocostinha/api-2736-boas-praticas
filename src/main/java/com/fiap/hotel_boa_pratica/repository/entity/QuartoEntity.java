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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QuartoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String numeroQuarto;

    @Column
    private TipoQuarto tipoQuarto;

    @Column
    private Status status;

    public enum TipoQuarto {
        CASAL,
        SOLTEIRO,
        DUPLO
    }

    public enum Status {
        DISPONIVEL,
        OCUPADO,
        EM_MANUTENCAO
    }

}
