package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public List<SerieDTO> obterTodasSeries() {
        return converteDados(serieRepository.findAll());
    }

    public List<SerieDTO> obterTop5Series() {
        return converteDados(serieRepository.findTop5ByOrderByAvaliacaoDesc());

    }

    public List<SerieDTO> obterLancamento() {
        return converteDados(serieRepository.findTop5ByOrderByEpisodiosDataLancamentoDesc());
    }

    public SerieDTO obterPorId(Long id) {
        Optional<Serie> serie = serieRepository.findById(id);
        if (serie.isPresent()) {
            Serie s = serie.get();
            return SerieDTO.from(s);
        }
        return null;
    }

    private List<SerieDTO> converteDados(@NotNull List<Serie> series) {
        return series.stream().map(SerieDTO::from)
            .collect(Collectors.toList());
    }
}
