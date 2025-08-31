package br.sp.senai.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sp.senai.escola.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

	
}
