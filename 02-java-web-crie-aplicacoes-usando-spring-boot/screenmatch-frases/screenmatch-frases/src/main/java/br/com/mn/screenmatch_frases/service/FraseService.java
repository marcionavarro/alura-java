package br.com.mn.screenmatch_frases.service;

import br.com.mn.screenmatch_frases.dto.FraseDTO;
import br.com.mn.screenmatch_frases.model.Frase;
import br.com.mn.screenmatch_frases.reapository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {

    @Autowired
    private FraseRepository fraseRepository;

    public FraseDTO obterFraseAleatoria() {
        Frase frase = fraseRepository.buscaFraseAleatoria();
        return new FraseDTO(frase.getTitulo(), frase.getFrase(), frase.getPersonagem(), frase.getPoster());
    }

}
