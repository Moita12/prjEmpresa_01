package com.Moises.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Moises.PrjEmpresa.entities.Departamento;

@Service
public class DepartamentoService {
	private final Departamento DepartamentoRepository;
	
	@Autowired
	public DepartamentoService(Departamento DepartamentoRepository) {
		this.DepartamentoRepository = DepartamentoRepository;
	}
	public Departamento getDepartamentoById(Long DepCodigo) {
		return DepartamentoRepository.findById(DepCodigo).orElse(null);
	}
    public List<Departamento> getAllDepartamento(){
        return DepartamentoRepository.findAll();
    }
	    public Departamento saveDepartamento(Departamento departamento) {
	        return DepartamentoRepository.save(departamento);
	    }
	    
	    public void deleteDepartamento(Long DepCodigo) {
	        DepartamentoRepository.deleteById(DepCodigo);
	}
	    public Departamento updateDepartamento(Long DepCodigo, Departamento novoDepartamento) {
	        Optional<Departamento> departamentoOptional = DepartamentoRepository.findById(DepCodigo);
	        if (departamentoOptional.isPresent()) {
	        	Departamento departamentoExistente = departamentoOptional.get();
	           	departamentoExistente.setDepNome(novoDepartamento.getDepNome());     
	            return DepartamentoRepository.save(departamentoExistente); 
	        } else {
	            return null; 
	        }
	    }
}
