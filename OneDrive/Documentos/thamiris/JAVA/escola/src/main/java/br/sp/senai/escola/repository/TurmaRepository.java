package br.sp.senai.escola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sp.senai.escola.model.Turma;

@Repository
public interface TurmaRepository 
						extends	
						JpaRepository<Turma, Long>{
	
	Optional<Turma> findByTitulo(String titulo);
	
}
