package com.fiap.hotel_boa_pratica.mapper;

import com.fiap.hotel_boa_pratica.controller.dto.QuartoDTO;
import com.fiap.hotel_boa_pratica.domain.Quarto;
import com.fiap.hotel_boa_pratica.repository.entity.QuartoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QuartoMapper {

    QuartoMapper INSTANCE = Mappers.getMapper(QuartoMapper.class);

    QuartoDTO toDTO(Quarto quarto);

    Quarto toDomain(QuartoDTO dto);

    Quarto toDomain(QuartoEntity quartoEntity);

    List<QuartoDTO> toListDTO(List<Quarto> quartoList);

    QuartoEntity toEntity(Quarto quarto);

    List<Quarto> toListDomain(List<QuartoEntity> quartoEntityList);

}
