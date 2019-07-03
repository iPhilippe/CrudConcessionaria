package br.com.fabrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fabrica.service.FabricanteService;

@Controller
@RequestMapping("/fabricante")
public class FabricanteController {
	
	@Autowired
	FabricanteService fabricanteService;
	
	@GetMapping("/listar")
	public ModelAndView listaFabricantes() {
		ModelAndView mv = new ModelAndView("/fabricante/listaFabricantes");
		mv.addObject("fabricantes", fabricanteService.listaFabricantes());
		return mv;
	}
}
