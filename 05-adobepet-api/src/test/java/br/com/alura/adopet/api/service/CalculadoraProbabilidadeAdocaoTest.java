package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroAbrigoDTO;
import br.com.alura.adopet.api.dto.CadastroPetDTO;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculadoraProbabilidadeAdocaoTest {

    @Test
    void cenario01() {
        Abrigo abrigo = new Abrigo(
            new CadastroAbrigoDTO("Abrigo feliz", "94999999999", "abrigofeliz@email.com")
        );
        Pet pet = new Pet(
            new CadastroPetDTO(TipoPet.GATO, "Miau", "Siames", 4, "Cinza", 4.0f),
            abrigo
        );

        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
    }

    @Test
    void cenario02() {
        Abrigo abrigo = new Abrigo(
            new CadastroAbrigoDTO("Abrigo feliz", "94999999999", "abrigofeliz@email.com")
        );
        Pet pet = new Pet(
            new CadastroPetDTO(TipoPet.GATO, "Miau", "Siames", 15, "Cinza", 4.0f),
            abrigo
        );

        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
    }

}