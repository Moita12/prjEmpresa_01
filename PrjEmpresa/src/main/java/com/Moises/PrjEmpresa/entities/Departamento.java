package com.Moises.PrjEmpresa.entities;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;

@Entity
@Table(name="tb_departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DepCodigo;
	private String DepNome;
	
	public Long getDepCodigo() {
		return DepCodigo;
	}

	public void setDepCodigo(Long depCodigo) {
		DepCodigo = depCodigo;
	}
	@Size(max=50, message = "Pãocovo")
	public String getDepNome() {
		return DepNome;
	}

	public void setDepNome(String depNome) {
		DepNome = depNome;
	}

	public Optional<Departamento> findById(Long depCodigo2) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Departamento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Departamento save(Departamento departamento) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteById(Long depCodigo2) {
		// TODO Auto-generated method stub
		
	}


	
	
}
