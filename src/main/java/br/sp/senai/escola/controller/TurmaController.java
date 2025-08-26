package br.sp.senai.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.senai.escola.model.Turma;
import br.sp.senai.escola.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {
	
	@Autowired
	TurmaService service;

	@PostMapping()
	public ResponseEntity<Turma> inserir(@RequestBody Turma turma){
	
	return ResponseEntity.ok(service. gravar(turma));
	
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> buscarPorId(@PathVariable Long id)
	
	return
}


