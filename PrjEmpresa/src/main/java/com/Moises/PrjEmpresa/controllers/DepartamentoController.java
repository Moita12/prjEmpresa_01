package com.Moises.PrjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Moises.PrjEmpresa.entities.Departamento;
import com.Moises.PrjEmpresa.services.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; 
	}
	private final DepartamentoService departamentoService;
	
	@Autowired
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Departamento> getDepartamento(@PathVariable long DepCodigo){
		Departamento departamento = departamentoService.getDepartamentoById(DepCodigo);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public Departamento createDepartamento(@RequestBody Departamento departamento) {
		return departamentoService.saveDepartamento(departamento);
	}
	@GetMapping
	public ResponseEntity<List<Departamento>> getAllDepartamento(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Departamento> departamento = departamentoService.getAllDepartamento();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(departamento);
	}
	
	@PutMapping("/{id}")
	public Departamento updateDepartamento(@PathVariable Long DepCodigo, @RequestBody Departamento departamento) {
	    return departamentoService.updateDepartamento(DepCodigo, departamento);
	}

@DeleteMapping("/{id}")
public void deleteDepartamento(@PathVariable Long DepCodigo) {
	departamentoService.deleteDepartamento(DepCodigo);
}
}
