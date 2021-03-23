package br.com.arfaxtec.sbmfullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arfaxtec.sbmfullstack.domain.GruposPrioridades;
/*
 * JpaRepository<GruposPrioridades, Long> A classe que vai ser trabalhada e o tipo da chave primaria da classe que no caso é long
 * */
public interface GruposPrioridadesRepository extends JpaRepository<GruposPrioridades, Long>{

	
}
