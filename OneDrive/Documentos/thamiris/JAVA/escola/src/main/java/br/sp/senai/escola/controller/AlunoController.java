package br.sp.senai.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.senai.escola.model.Aluno;
import br.sp.senai.escola.service.AlunoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	@Autowired
	AlunoService service;

	@GetMapping
	public ResponseEntity<List<Aluno>> buscar(){
		return ResponseEntity.ok(service.buscar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscarPorId(
								  @PathVariable Long id){
		return ResponseEntity.ok(service.buscarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Aluno> inserir(
			  @RequestBody Aluno aluno){
		return ResponseEntity.ok(service.gravar(aluno));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> alterar(
			  @PathVariable Long id,
			  @RequestBody Aluno aluno){
		return ResponseEntity.ok(service.gravar(aluno));
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(
			@PathVariable Long id){
		if(service.excluir(id))
			return ResponseEntity.status(
					HttpStatus.OK).build();
		else
			return ResponseEntity.status(
					HttpStatus.BAD_REQUEST).build();
	}
	
	
	
	
}
