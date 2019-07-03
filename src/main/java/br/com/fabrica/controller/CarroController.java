package br.com.fabrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fabrica.dominio.Carro;
import br.com.fabrica.service.CarroService;

@Controller
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@GetMapping("/listar")
	public ModelAndView listaCarros() {
		ModelAndView mv = new ModelAndView("/carro/listaCarros");
		mv.addObject("carros", carroService.listaCarros());
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView add(Carro carro) {
		ModelAndView mv = new ModelAndView("/carro/addCarros");
		mv.addObject(carro);
		return mv;	
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(Carro carro) {
		carroService.inserir(carro);
		return listaCarros();
	}
	
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		carroService.excluir(id);
		return listaCarros();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("/carro/alteraCarros");
		mv.addObject("carro", carroService.busca(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Carro carro) {
		carroService.alterar(carro);
		return listaCarros();
	}
	
}
