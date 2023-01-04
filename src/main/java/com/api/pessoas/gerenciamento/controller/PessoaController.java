package com.api.pessoas.gerenciamento.controller;

import com.api.pessoas.gerenciamento.model.Endereco;
import com.api.pessoas.gerenciamento.model.Pessoa;
import com.api.pessoas.gerenciamento.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaServiceImpl pessoaService;

    @PostMapping("/cadastrarNova")
    public Pessoa salvaPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.salvaPessoa(pessoa);
    }

    @GetMapping("/listarTodas")
    public List<Pessoa> listaDePessoas(){
        return pessoaService.listaDePessoas();
    }

    @GetMapping("/consultar/{id}")
    public Pessoa consultaPessoa(@PathVariable Long id){
        return pessoaService.consultaPessoa(id);
    }

    @PutMapping("atualizarDados/{id}")
    public Pessoa atualizaDadosPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa){
        return pessoaService.atualizaDadosPessoa(id, pessoa);
    }

    @PostMapping("adicionarNovoEndereco/{id}")
    public Pessoa adicionaNovoEndereco(@PathVariable Long id, @RequestBody Endereco endereco){
        return pessoaService.adicionaNovoEndereco(endereco, id);
    }

    @GetMapping("enderecos/{id}")
    public List<Endereco> enderecosPessoa(@PathVariable Long id){
        return pessoaService.listaEnderecosPessoa(id);
    }
}
