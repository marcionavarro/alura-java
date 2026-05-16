package br.com.alura.screenmatch.dto;

import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Serie;

public record SerieDTO(Long id,
                       String titulo,
                       Integer totalTemporadas,
                       Double avaliacao,
                       Categoria genero,
                       String atores,
                       String poster,
                       String sinopse) {

    public static SerieDTO from(Serie s) {
        return new SerieDTO(s.getId(),
                            s.getTitulo(),
                            s.getTotalTemporadas(),
                            s.getAvaliacao(),
                            s.getGenero(),
                            s.getAtores(),
                            s.getPoster(),
                            s.getSinopse());
    }
}
