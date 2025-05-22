package com.fiap.hotel_boa_pratica.business;

import com.fiap.hotel_boa_pratica.domain.Quarto;
import com.fiap.hotel_boa_pratica.domain.Reserva;
import com.fiap.hotel_boa_pratica.exception.RegraDeNegocioException;
import com.fiap.hotel_boa_pratica.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class ReservaBusiness {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private QuartoBusiness quartoBusiness;

    public Reserva cadastrarReserva(final Reserva reserva) {

        Quarto quartoSolicitado = quartoBusiness.findByNumeroQuarto(reserva.getNumeroQuarto());

        if (quartoSolicitado.getStatus().equals(Quarto.Status.EM_MANUTENCAO) ||
            quartoSolicitado.getStatus().equals(Quarto.Status.OCUPADO)) {
            throw new RegraDeNegocioException("Quarto não disponível para reserva");
        }

        reserva.setId(null);

        return reservaService.salvar(reserva);
    }

    public Reserva alterarReserva(final Reserva reserva) {
        Optional<Reserva> reservaExistente = reservaService.findById(reserva.getId());

        if (reservaExistente.isEmpty()) {
            throw new RegraDeNegocioException("Reserva não encontrada");
        }

        if (reservaExistente.get().getStatus().equals(Reserva.Status.CANCELADA) ||
            reservaExistente.get().getStatus().equals(Reserva.Status.EM_ANDAMENTO)) {
            throw new RegraDeNegocioException("Reserva não pode ser alterada");
        }

        if (!reservaExistente.get().getNumeroQuarto().equals(reserva.getNumeroQuarto())) {
            Quarto quartoSolicitado = quartoBusiness.findByNumeroQuarto(reserva.getNumeroQuarto());

            if (quartoSolicitado.getStatus().equals(Quarto.Status.EM_MANUTENCAO) ||
                quartoSolicitado.getStatus().equals(Quarto.Status.OCUPADO)) {
                throw new RegraDeNegocioException("Quarto não disponível para reserva");
            }
        }

        Reserva reservaAtualizada = reservaService.salvar(reserva);

        return reservaAtualizada;
    }

    public Reserva iniciarReserva(final Integer id) {
        Reserva reservaExistente = reservaService.findById(id).orElseThrow(() -> new RegraDeNegocioException("Reserva não encontrada"));

        if (reservaExistente.getStatus().equals(Reserva.Status.CANCELADA) ||
            reservaExistente.getStatus().equals(Reserva.Status.EM_ANDAMENTO)) {
            throw new RegraDeNegocioException("Reserva não pode ser iniciada");
        }

        reservaExistente.setStatus(Reserva.Status.EM_ANDAMENTO);

        Reserva reservaIniciada = reservaService.salvar(reservaExistente);

        return reservaIniciada;
    }

    public Reserva buscarPorId(final Integer id) {
        return reservaService.findById(id).orElseThrow(() -> new RegraDeNegocioException("Reserva não encontrada"));
    }

    public List<Reserva> buscarPorDataEntradaOuDataSaidaOuStatus(final LocalDate dataEntrada, final LocalDate dataSaida, final String status) {
        return reservaService.buscarPorDataEntradaOuDataSaidaOuStatus(dataEntrada, dataSaida, status);
    }

}
