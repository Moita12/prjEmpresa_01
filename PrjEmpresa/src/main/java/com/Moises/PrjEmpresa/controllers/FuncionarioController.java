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

import com.Moises.PrjEmpresa.entities.Funcionario;
import com.Moises.PrjEmpresa.services.FuncionarioService;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; 
	}
	private final FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable long FunCodigo){
		Funcionario funcionario = funcionarioService.getFuncionarioById(FunCodigo);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.saveFuncionario(funcionario);
	}
	@GetMapping
	public ResponseEntity<List<Funcionario>> getAllFuncionario(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Funcionario> funcionario = funcionarioService.getAllFuncionario();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(funcionario);
	}
	
	@PutMapping("/{id}")
	public Funcionario updateFuncionario(@PathVariable Long FunCodigo, @RequestBody Funcionario funcionario) {
	    return funcionarioService.updateFuncionario(FunCodigo, funcionario);
	}

@DeleteMapping("/{id}")
public void deleteFuncionario(@PathVariable Long FunCodigo) {
	funcionarioService.deleteFuncionario(FunCodigo);
}
}
