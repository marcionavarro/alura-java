package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AtualizarDTO;
import br.com.alura.adopet.api.dto.CadastrarTutorDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public void cadastrar(CadastrarTutorDTO dto) {
        boolean tutorCadastrado = tutorRepository.findByTelefoneOrEmail(dto.telefone(), dto.email());

        if (tutorCadastrado) {
            throw new ValidacaoException("\"Dados já cadastrados para outro tutor!\"");
        }

        tutorRepository.save(new Tutor(dto));
    }

    public void atualizar(@Valid AtualizarDTO dto) {
        Tutor tutor = tutorRepository.getReferenceById(dto.id());
        tutor.atualizarDados(dto);
    }
}
