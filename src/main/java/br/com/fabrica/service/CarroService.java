package br.com.fabrica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabrica.dominio.Carro;
import br.com.fabrica.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;
	
	
	public Carro save(Carro carro) {
		return carroRepository.save(carro);
	}
	
	public List<Carro> saveAll(List<Carro> carros){
		return carroRepository.saveAll(carros);
	}
	
	public List<Carro> listaCarros(){
		return carroRepository.findAll();
	}
	
	public Carro inserir(Carro carro) {
		carro.setChassi(null);
		return carroRepository.save(carro);
	}
	
	public Carro busca(Integer chassi) {
		Optional<Carro> objCarro = carroRepository.findById(chassi);
		return objCarro.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrada. Id: " + chassi));	
	}
	
	public void excluir(Integer chassi) {
		
		carroRepository.deleteById(chassi);
	}
	
	public Carro alterar(Carro carro) {
		Carro carroEncontrado = busca(carro.getChassi());
		carroEncontrado.setModelo(carro.getModelo());
		return carroRepository.save(carroEncontrado);
		
	}
	
	
	
}
