package br.com.arfaxtec.sbmfullstack.repository;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arfaxtec.sbmfullstack.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
