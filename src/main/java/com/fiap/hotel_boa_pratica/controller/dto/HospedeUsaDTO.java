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
public class HospedeUsaDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String document;

    @NotNull
    private LocalDate birthdate;

    private String address;

    @NotEmpty
    private String email;

    private String phone;

}
