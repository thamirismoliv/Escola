package br.sp.senai.escola.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.sp.senai.escola.model.Turma;
import br.sp.senai.escola.repository.TurmaRepository;

@Service
public class TurmaService {
	
	TurmaRepository repo;
	
	public TurmaService(TurmaRepository r) {
		
		repo = r;
	}
	
	public Turma gravar(Turma turma) {
		
		return repo.save(turma);
	}

    
	public Turma buscarPorId(Long id) {
		
		Optional<Turma> opc = repo.findById(id);
		
		return opc.orElse(null);
	}
}
