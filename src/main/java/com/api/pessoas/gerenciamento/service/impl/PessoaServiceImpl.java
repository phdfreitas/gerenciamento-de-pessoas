package com.api.pessoas.gerenciamento.service.impl;

import com.api.pessoas.gerenciamento.model.Endereco;
import com.api.pessoas.gerenciamento.model.Pessoa;
import com.api.pessoas.gerenciamento.model.enums.TipoEndereco;
import com.api.pessoas.gerenciamento.repository.EnderecoRepository;
import com.api.pessoas.gerenciamento.repository.PessoaRepository;
import com.api.pessoas.gerenciamento.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Pessoa salvaPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @Override
    public List<Pessoa> listaDePessoas(){
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa consultaPessoa(Long id){
        return pessoaRepository.findById(id).get();
    }

    @Override
    public Pessoa atualizaDadosPessoa(Long id, Pessoa pessoa){
        Pessoa pessoaAtualizada = consultaPessoa(id);
        pessoaAtualizada.setNome(pessoa.getNome());
        pessoaAtualizada.setDataDeNascimento(pessoa.getDataDeNascimento());

        return pessoaRepository.save(pessoaAtualizada);
    }

    @Override
    public Pessoa adicionaNovoEndereco(Endereco endereco, Long idPessoa){
        Pessoa pessoa = consultaPessoa(idPessoa);

        if(endereco.getTipoEndereco() == null)
            endereco.setTipoEndereco(TipoEndereco.SECUNDARIO);

        pessoa.getEnderecos().add(endereco);
        endereco.setPessoa(pessoa);

        enderecoRepository.save(endereco);

        return pessoaRepository.save(pessoa);
    }

    @Override
    public List<Endereco> listaEnderecosPessoa(Long idPessoa){
        return consultaPessoa(idPessoa).getEnderecos();
    }
}
