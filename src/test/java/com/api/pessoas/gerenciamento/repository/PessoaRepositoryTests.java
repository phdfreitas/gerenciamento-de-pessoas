package com.api.pessoas.gerenciamento.repository;

import com.api.pessoas.gerenciamento.model.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PessoaRepositoryTests {

    @Autowired
    private PessoaRepository pessoaRepository;

    private Pessoa pessoa;

    @BeforeEach
    public void setup(){
        pessoa = new Pessoa(1L, "Pedro Freitas", LocalDate.now());
    }

    @DisplayName("Teste para salvar uma nova pessoa")
    @Test
    public void givenPessoa_whenSalvaNovaPessoa_thenRetornaPessoaSalva(){
        //given - Neste caso é feito no @BeforeEach

        //when
        Pessoa novaPessoa = pessoaRepository.save(pessoa);

        //then
        assertThat(novaPessoa).isNotNull();
    }

    @DisplayName("Teste para listar todas as pessoas")
    @Test
    public void givenListaDePessoas_whenListarPessoas_thenRetornaTodasAsPessoas(){
        //given
        Pessoa pessoa2 = new Pessoa(2L, "Ana Beatriz", LocalDate.now());
        pessoaRepository.saveAll(Arrays.asList(pessoa, pessoa2));

        //when
        List<Pessoa> listaDePessoas = pessoaRepository.findAll();

        //then
        assertThat(listaDePessoas).size().isEqualTo(2);
    }

    @DisplayName("Teste para consultar uma pessoa")
    @Test
    public void givenIdPessoa_whenConsultarPessoa_thenRetornaPessoaSalva(){
        //given - A pessoa deve estar no banco
        pessoaRepository.save(pessoa);

        //when
        Pessoa pessoaDB = pessoaRepository.findById(pessoa.getId()).get();

        //then
        assertThat(pessoaDB).isNotNull();
    }

    @DisplayName("Teste para editar uma pessoa")
    @Test
    public void givenPessoa_whenAtualizarPessoa_thenRetornaPessoaAtualizada(){
        //given
        pessoaRepository.save(pessoa);

        //when
        Pessoa pessoaDB = pessoaRepository.findById(pessoa.getId()).get();
        pessoaDB.setNome("Pedro Dias");
        pessoaDB.setDataDeNascimento(LocalDate.of(1998, 01, 01));
        Pessoa pessoaAtualizada = pessoaRepository.save(pessoaDB);

        //then
        assertThat(pessoaAtualizada.getNome()).isEqualTo("Pedro Dias");
    }
}
