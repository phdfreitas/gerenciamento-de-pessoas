package com.api.pessoas.gerenciamento.service;

import com.api.pessoas.gerenciamento.model.Endereco;
import com.api.pessoas.gerenciamento.model.Pessoa;

import java.util.List;

public interface PessoaService {

    Pessoa salvaPessoa(Pessoa pessoa);
    List<Pessoa> listaDePessoas();
    Pessoa consultaPessoa(Long id);
    Pessoa atualizaDadosPessoa(Long id, Pessoa pessoa);
    Pessoa adicionaNovoEndereco(Endereco endereco, Long idPessoa);
    List<Endereco> listaEnderecosPessoa(Long idPessoa);

}
