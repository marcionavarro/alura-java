package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AtualizarTutorDTO;
import br.com.alura.adopet.api.dto.CadastroTutorDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class TutorServiceTest {

    @InjectMocks
    private TutorService tutorService;

    @Mock
    private TutorRepository tutorRepository;

    @Mock
    private CadastroTutorDTO dto;

    @Mock
    private Tutor tutor;

    @Mock
    private AtualizarTutorDTO atualizarTutorDTO;

    @Test
    void naoDeveriaCadastrarTutorTelefoneOuEmailJaCadastrado() {
        // Arrange + Act
        given(tutorRepository.existsByTelefoneOrEmail(dto.telefone(), dto.email())).willReturn(true);

        // Assert
        assertThrows(ValidacaoException.class, () -> tutorService.cadastrar(dto));
    }

    @Test
    void deveriaCadastrarTutor() {
        // Arrange + Act
        given(tutorRepository.existsByTelefoneOrEmail(dto.telefone(), dto.email())).willReturn(false);

        // Assert
        assertDoesNotThrow(() -> tutorService.cadastrar(dto));
        then(tutorRepository).should().save(new Tutor(dto));
    }

    @Test
    void deveriaAtualizarTutor() {
        // Arrange
        given(tutorRepository.getReferenceById(atualizarTutorDTO.id())).willReturn(tutor);

        // Act
        tutorService.atualizar(atualizarTutorDTO);

        // Assert
        then(tutor).should().atualizarDados(atualizarTutorDTO);
    }


}