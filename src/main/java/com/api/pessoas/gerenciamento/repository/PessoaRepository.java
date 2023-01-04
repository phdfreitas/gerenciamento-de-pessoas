package com.api.pessoas.gerenciamento.repository;

import com.api.pessoas.gerenciamento.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
