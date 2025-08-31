package br.sp.senai.escola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sp.senai.escola.model.Aluno;
import br.sp.senai.escola.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repo;

	public List<Aluno> buscar() {
		return repo.findAll();
	}

	public Aluno buscarPorId(Long id) {
		Optional<Aluno> opc = repo.findById(id);

		return opc.orElse(null);
	}

	public Aluno gravar(Aluno aluno) {
		return repo.save(aluno);
	}

	public boolean excluir(Long id) {
		repo.deleteById(id);
		var opc = repo.findById(id);
		return opc.isEmpty();
	}

}
