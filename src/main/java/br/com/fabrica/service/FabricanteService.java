package br.com.fabrica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabrica.dominio.Fabricante;
import br.com.fabrica.repository.FabricanteRepository;

@Service
public class FabricanteService {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	public Fabricante save(Fabricante fabricante) {
		return fabricanteRepository.save(fabricante);
	}
	
	public List<Fabricante> saveAll(List<Fabricante> fabricantes) {
		return fabricanteRepository.saveAll(fabricantes);
	}
	
	public List<Fabricante> listaFabricantes(){
		return fabricanteRepository.findAll();
	}
}
