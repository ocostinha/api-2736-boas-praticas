package com.fiap.hotel_boa_pratica.mapper;

import com.fiap.hotel_boa_pratica.controller.dto.ReservaDTO;
import com.fiap.hotel_boa_pratica.domain.Reserva;
import com.fiap.hotel_boa_pratica.repository.entity.ReservaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservaMapper {

    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    Reserva toDomain(ReservaDTO dto);

    ReservaDTO toDTO(Reserva reserva);

    List<ReservaDTO> toDTO(List<Reserva> reserva);

    ReservaEntity toEntity(Reserva reserva);

    Reserva toDomain(ReservaEntity reservaEntity);

    List<Reserva> toDomain(List<ReservaEntity> reservaEntity);

}
