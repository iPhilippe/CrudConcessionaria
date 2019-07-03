package br.com.fabrica.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.fabrica.dominio.Acessorio;
import br.com.fabrica.dominio.Carro;
import br.com.fabrica.dominio.Chave;
import br.com.fabrica.dominio.Fabricante;
import br.com.fabrica.repository.AcessorioRepository;
import br.com.fabrica.repository.CarroRepository;
import br.com.fabrica.repository.ChaveRepository;
import br.com.fabrica.repository.FabricanteRepository;
import br.com.fabrica.service.AcessorioService;
import br.com.fabrica.service.ChaveService;
import br.com.fabrica.service.FabricanteService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	AcessorioService acessorioService;
	
	@Autowired
	ChaveService chaveService;
	
	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	FabricanteService fabricanteService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		//Refazer as chamadas através dos Serviços e não dos repositórios
		
		// Fabricante
		Fabricante fabricante1 = new Fabricante();
		fabricante1.setNome("Honda");
		Fabricante fabricante2 = new Fabricante();
		fabricante2.setNome("Renault");
		fabricanteService.saveAll(Arrays.asList(fabricante1,fabricante2));
		
		// Chave
		Chave chave1 = new Chave();
		chave1.setCodigo("txt-5637893458");
		Chave chave2 = new Chave();
		chave2.setCodigo("gty-2783728379");
		Chave chave3 = new Chave();
		chave3.setCodigo("srr-2309598543");
		chaveService.saveAll(Arrays.asList(chave1,chave2,chave3));
		
		// Acessorio
		Acessorio acessorio1 = new Acessorio();
		acessorio1.setNome("Radio");
		Acessorio acessorio2 = new Acessorio();
		acessorio2.setNome("Ar-condicionado");
		acessorioService.saveAll(Arrays.asList(acessorio1,acessorio2));
		
		// Carro
		Carro carro1 = new Carro();
		carro1.setModelo("Civic");
		carro1.setFabricante(fabricante1);
		carro1.setChave(chave1);
		carro1.setAcessorios(Arrays.asList(acessorio1,acessorio2));
		
		// Carro2
		Carro carro2 = new Carro();
		carro2.setModelo("Logan");
		carro2.setFabricante(fabricante2);
		carro2.setChave(chave2);
		carro2.setAcessorios(Arrays.asList(acessorio2));
		
		carroRepository.save(carro1);
		carroRepository.save(carro2);
		
	}



}
