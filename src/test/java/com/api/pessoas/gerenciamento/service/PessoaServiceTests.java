package com.api.pessoas.gerenciamento.service;

import com.api.pessoas.gerenciamento.model.Pessoa;
import com.api.pessoas.gerenciamento.repository.PessoaRepository;
import com.api.pessoas.gerenciamento.service.impl.PessoaServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTests {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaServiceImpl pessoaService;

    private Pessoa pessoa;

    @BeforeEach
    public void setup(){
        pessoa = new Pessoa(1L, "Pedro Freitas", LocalDate.now());
    }

    @DisplayName("Teste para salvar uma nova pessoa")
    @Test
    public void givenPessoa_whenSalvarPessoa_thenRetornaPessoaSalva(){
        given(pessoaRepository.save(pessoa)).willReturn(pessoa);

        Pessoa pessoaSalva = pessoaService.salvaPessoa(pessoa);

        assertThat(pessoaSalva).isNotNull();
    }

    @DisplayName("Teste para listar todas as pessoas")
    @Test
    public void givenListaDePessoas_whenListarPessoas_thenRetornaTodasAsPessoas(){
        //given
        Pessoa pessoa2 = new Pessoa(2L, "Ana Beatriz", LocalDate.now());
        given(pessoaRepository.findAll()).willReturn(Arrays.asList(pessoa, pessoa2));

        //when
        List<Pessoa> listaDePessoas = pessoaService.listaDePessoas();

        //then
        assertThat(listaDePessoas).isNotNull();
        assertThat(listaDePessoas).size().isEqualTo(2);
    }

    @DisplayName("Teste para consultar uma pessoa")
    @Test
    public void givenIdPessoa_whenConsultarPessoa_thenRetornaPessoaSalva(){
        //given - A pessoa deve estar no banco
        given(pessoaRepository.findById(1L)).willReturn(Optional.of(pessoa));

        //when
        Pessoa pessoaDB = pessoaService.consultaPessoa(pessoa.getId());

        //then
        assertThat(pessoaDB).isNotNull();
    }
    @DisplayName("Teste para editar uma pessoa")
    @Test
    public void givenPessoa_whenAtualizarPessoa_thenRetornaPessoaAtualizada(){
        //given
        given(pessoaRepository.save(pessoa)).willReturn(pessoa);
        pessoa.setNome("Pedro Dias");
        pessoa.setDataDeNascimento(LocalDate.of(1998, 01, 01));

        given(pessoaRepository.findById(1L)).willReturn(Optional.of(pessoa));

        //when
        Pessoa pessoaAtualizada = pessoaService.atualizaDadosPessoa(1L, pessoa);

        //then
        assertThat(pessoaAtualizada).isNotNull();
        assertThat(pessoaAtualizada.getNome()).isEqualTo("Pedro Dias");
    }
}
