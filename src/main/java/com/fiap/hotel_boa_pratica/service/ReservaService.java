package com.fiap.hotel_boa_pratica.service;

import com.fiap.hotel_boa_pratica.domain.Reserva;
import com.fiap.hotel_boa_pratica.mapper.ReservaMapper;
import com.fiap.hotel_boa_pratica.repository.ReservaRepository;
import com.fiap.hotel_boa_pratica.repository.entity.ReservaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    private ReservaMapper mapper = ReservaMapper.INSTANCE;

    public Reserva salvar(final Reserva reserva) {
        ReservaEntity reservaCadastrada = reservaRepository.save(mapper.toEntity(reserva));

        return mapper.toDomain(reservaCadastrada);
    }

    public Optional<Reserva> findById(final Integer id) {
        Optional<ReservaEntity> reservaEntity = reservaRepository.findById(id);

        return reservaEntity.map(mapper::toDomain);
    }

    public List<Reserva> buscarPorDataEntradaOuDataSaidaOuStatus(final LocalDate dataEntrada, final LocalDate dataSaida, final String status) {
        List<ReservaEntity> reservas = reservaRepository.findByDataEntradaOrDataSaidaOrStatus(
            dataEntrada,
            dataSaida,
            ReservaEntity.Status.valueOf(status)
        );

        return mapper.toDomain(reservas);
    }

}
