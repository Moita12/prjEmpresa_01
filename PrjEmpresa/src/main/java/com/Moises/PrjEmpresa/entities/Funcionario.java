package com.Moises.PrjEmpresa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tb_funcionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long FunCodigo;
	@Size(max=100, message = "Pãocovo")
	private String FunNome;
	
	private Float FunSalario;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	   private LocalDate funnascimento;
	public Long getFunCodigo() {
		return FunCodigo;
	}

	public void setFunCodigo(Long funCodigo) {
		FunCodigo = funCodigo;
	}

	public String getFunNome() {
		return FunNome;
	}

	public void setFunNome(String funNome) {
		FunNome = funNome;
	}

	public Float getFunSalario() {
		return FunSalario;
	}

	public void setFunSalario(Float funSalario) {
		FunSalario = funSalario;
	}

	public LocalDate getFunnascimento() {
		return funnascimento;
	}

	public void setFunnascimento(LocalDate funnascimento) {
		this.funnascimento = funnascimento;
	}

	public List<Funcionario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Funcionario save(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteById(Long funCodigo2) {
		// TODO Auto-generated method stub
		
	}

	public Optional<Funcionario> findbyId(Long funCodigo2) {
		// TODO Auto-generated method stub
		return null;
	}


}
