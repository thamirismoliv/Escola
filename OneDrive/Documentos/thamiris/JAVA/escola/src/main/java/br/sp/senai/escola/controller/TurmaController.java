package br.sp.senai.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<Turma> inserir(@RequestBody Turma turma) {

		return ResponseEntity.ok(service.gravar(turma));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> buscarPorId(@PathVariable Long id) {
		Turma turma = service.buscarPorId(id);
		if (turma == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(turma);
	}

	@GetMapping
	public ResponseEntity<List<Turma>> buscar() {

		List<Turma> turmas = service.buscar();
		if (turmas.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(turmas);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Turma> alterar(@PathVariable Long id, @RequestBody Turma turma) {
		turma.setId(id);
		var tmp = service.buscarPorId(id);
		if (tmp == null)
			return ResponseEntity.notFound().build();
		else {
			return ResponseEntity.ok(service.alterar(turma));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Turma> excluir(
			@PathVariable Long id){
		
		Turma turma = service.buscarPorId(id);
		if (turma == null)
			return ResponseEntity.notFound().build();
		else {
			if (service.excluir(id))
				return ResponseEntity.ok(
						turma);
			else
				return ResponseEntity.badRequest()
						.build();
		}
	}
	
	@GetMapping("buscar/{titulo}")
	public ResponseEntity<Turma> buscarPorTitulo(
			@PathVariable String titulo) {
		
		var turma = service.buscarPorTitulo(titulo);
		if (turma==null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(turma);
	}
	

}
