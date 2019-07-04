package br.com.fabrica.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.fabrica.dominio.Acessorio;
import br.com.fabrica.dominio.Carro;
import br.com.fabrica.dominio.Chave;
import br.com.fabrica.dominio.Documento;
import br.com.fabrica.dominio.Fabricante;
import br.com.fabrica.repository.AcessorioRepository;
import br.com.fabrica.repository.CarroRepository;
import br.com.fabrica.repository.ChaveRepository;
import br.com.fabrica.repository.FabricanteRepository;
import br.com.fabrica.service.AcessorioService;
import br.com.fabrica.service.ChaveService;
import br.com.fabrica.service.DocumentoService;
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
	DocumentoService documentoService;
	
	@Autowired
	FabricanteService fabricanteService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		
		// Fabricante
		Fabricante fabricante1 = new Fabricante();
		fabricante1.setNome("Volkswagem");
		Fabricante fabricante2 = new Fabricante();
		fabricante2.setNome("Subaru");
		fabricanteService.saveAll(Arrays.asList(fabricante1,fabricante2));
		
		// Chave
		Chave chave1 = new Chave();
		chave1.setCodigo("ghg-5321365344");
		Chave chave2 = new Chave();
		chave2.setCodigo("tye-2783728379");
		Chave chave3 = new Chave();
		chave3.setCodigo("die-2309598544");
		chaveService.saveAll(Arrays.asList(chave1,chave2,chave3));
		
		//Documento
		Documento documento1= new Documento();
		documento1.setNumero("cvc-53289");
		Documento documento2= new Documento();
		documento2.setNumero("tvt-22453");
		documentoService.saveAll(Arrays.asList(documento1,documento2));
		
		// Acessorio
		Acessorio acessorio1 = new Acessorio();
		acessorio1.setNome("Direção Hidráulica");
		acessorio1.setPreco((float) 1000.00);
		Acessorio acessorio2 = new Acessorio();
		acessorio2.setPreco((float) 1500.00);
		acessorio2.setNome("Ar-condicionado");
		acessorioService.saveAll(Arrays.asList(acessorio1,acessorio2));
		
		// Carro
		Carro carro1 = new Carro();
		carro1.setModelo("WRX");
		carro1.setFabricante(fabricante1);
		carro1.setChave(chave1);
		carro1.setDocumento(documento1);
		carro1.setAcessorios(Arrays.asList(acessorio1,acessorio2));
		
		// Carro2
		Carro carro2 = new Carro();
		carro2.setModelo("Fusca");
		carro2.setFabricante(fabricante2);
		carro2.setChave(chave2);
		carro2.setDocumento(documento2);
		carro2.setAcessorios(Arrays.asList(acessorio2));
		
		carroRepository.save(carro1);
		carroRepository.save(carro2);
		
	}



}
