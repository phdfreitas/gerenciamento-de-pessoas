package com.api.pessoas.gerenciamento.repository;

import com.api.pessoas.gerenciamento.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
