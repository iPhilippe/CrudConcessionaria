package br.com.fabrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fabrica.dominio.Acessorio;
import br.com.fabrica.service.AcessorioService;

@Controller
@RequestMapping("/acessorio")
public class AcessorioController {
	
	@Autowired
	private AcessorioService acessorioService;
	
	@GetMapping("/listar")
	public ModelAndView listaAcessorios() {
		ModelAndView mv = new ModelAndView("/acessorio/listaAcessorios");
		mv.addObject("acessorios", acessorioService.listaAcessorios());
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView add(Acessorio acessorio) {
		ModelAndView mv = new ModelAndView("/acessorio/addAcessorios");
		mv.addObject(acessorio);
		return mv;	
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(Acessorio acessorio) {
		acessorioService.inserir(acessorio);
		return listaAcessorios();
	}
	
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		acessorioService.excluir(id);
		return listaAcessorios();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("/acessorio/alteraAcessorios");
		mv.addObject("acessorio", acessorioService.busca(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Acessorio acessorio) {
		acessorioService.alterar(acessorio);
		return listaAcessorios();
	}
	
}
