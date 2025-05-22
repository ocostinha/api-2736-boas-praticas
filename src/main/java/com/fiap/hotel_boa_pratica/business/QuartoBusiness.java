package com.fiap.hotel_boa_pratica.business;

import com.fiap.hotel_boa_pratica.domain.Quarto;
import com.fiap.hotel_boa_pratica.exception.RegraDeNegocioException;
import com.fiap.hotel_boa_pratica.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuartoBusiness {

    @Autowired
    private QuartoService quartoService;

    public Quarto create(final Quarto quarto) {
        if (quartoService.findByNumeroQuarto(quarto.getNumeroQuarto()).isPresent()) {
            throw new RegraDeNegocioException("Número do quarto já cadastrado");
        }

        quarto.setId(null);
        Quarto quartoSalvo = quartoService.save(quarto);

        return quartoSalvo;
    }

    public Quarto update(final Quarto quarto) {
        if (quartoService.findByIdAndNumeroQuarto(quarto.getId(), quarto.getNumeroQuarto()).isEmpty()) {
            if (quartoService.findByNumeroQuarto(quarto.getNumeroQuarto()).isPresent()) {
                throw new RegraDeNegocioException("Número do quarto já cadastrado");
            }
        }

        Quarto quartoSalvo = quartoService.save(quarto);

        return quartoSalvo;
    }

    public List<Quarto> findAll() {
        return quartoService.findAll();
    }

    public Quarto findById(final Integer id) {
        return quartoService.findById(id)
            .orElseThrow(() -> new RegraDeNegocioException("Quarto não encontrado"));
    }

    public List<Quarto> findByStatusOrTipoAcomodacaoOrNumeroQuarto(final String status, final String tipoAcomodacao, final String numeroQuarto) {
        return quartoService.findByStatusOrTipoAcomodacaoOrNumeroQuarto(status, tipoAcomodacao, numeroQuarto);
    }

}
