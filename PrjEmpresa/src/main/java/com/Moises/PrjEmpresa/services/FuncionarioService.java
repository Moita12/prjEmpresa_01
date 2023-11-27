package com.Moises.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Moises.PrjEmpresa.entities.Funcionario;

@Service
public class FuncionarioService {
	private final Funcionario FuncionarioRepository;
	
	@Autowired
	public FuncionarioService(Funcionario FuncionarioRepository) {
		this.FuncionarioRepository = FuncionarioRepository;
	}
	public Funcionario getFuncionarioById(Long FunCodigo) {
		return FuncionarioRepository.findbyId(FunCodigo).orElse(null);
	}
    public List<Funcionario> getAllFuncionario(){
        return FuncionarioRepository.findAll();
    }
	    public Funcionario saveFuncionario(Funcionario funcionario) {
	        return FuncionarioRepository.save(funcionario);
	    }
	    
	    public void deleteFuncionario(Long FunCodigo) {
	    	FuncionarioRepository.deleteById(FunCodigo);
	}
	    public Funcionario updateFuncionario(Long FunCodigo, Funcionario novoFuncionario) {
	        Optional<Funcionario> funcionarioOptional = FuncionarioRepository.getFunCodigo(FunCodigo);
	        if (funcionarioOptional.isPresent()) {
	        	Funcionario funcionarioExistente = funcionarioOptional.get();
	           	funcionarioExistente.setFunNome(novoFuncionario.getFunNome());
	           	funcionarioExistente.setFunSalario(novoFuncionario.getFunSalario());
	           	funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());     
	            return FuncionarioRepository.save(funcionarioExistente); 
	        } else {
	            return null; 
	        }
	    }
}
